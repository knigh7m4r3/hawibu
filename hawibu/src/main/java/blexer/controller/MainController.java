package blexer.controller;

import blexer.model.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;


public class MainController {


    private final Stage stage;

    private final EntityManager em;

    @FXML
    private ScrollPane scrollPaneJahr;

    @FXML
    private ScrollPane scrollPaneDetail;

    private TreeView<String> treeViewJahr;

    private List<Jahr> jahrList = new ArrayList<>();

    private final Map<String, List<Bon>> monatBonMap = new HashMap<>();

    private String currentSelection = "";


    public MainController(Stage stage, EntityManager em){
        this.stage = stage;
        this.em = em;


    }

    @FXML
    public void initialize() {
        System.out.println("Hallo init...");
        this.initScrollPaneJahr();

        this.treeViewJahr.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> observable, TreeItem<String> oldValue, TreeItem<String> newValue) {
                System.out.println("Clicked on:\t" + newValue.getValue());
                String val = newValue.getValue();
                MainController.this.currentSelection = val;
                List<Bon> bonList = selectBon(val);
                processBonList(bonList);
            }
        });
        if(!this.currentSelection.isEmpty()){
            processBonList(selectBon(currentSelection));
        }
    }

    private List<Bon> selectBon(String val){
        final List<Bon> bonList = new ArrayList<>();
        if(val.length() == 4){
            List<Monat> monatList = MainController.this.em.createQuery("from Monat m where m.jahr.jahr = " +  val).getResultList();
            for(Monat m : monatList){
                if(MainController.this.monatBonMap.containsKey(m.getName())) {
                    bonList.addAll(MainController.this.monatBonMap.get(m.getName()));
                }
            }
        }else{
            bonList.addAll(MainController.this.monatBonMap.get(val));
        }
        return bonList;
    }

    private void processBonList(List<Bon> bonList){
        Map<Kategorie, Double> kategorieMap = new HashMap<>();
        for(Bon b: bonList){
            List<Posten> postenList = this.em.createQuery("from Posten p where p.bon.id = " + b.getId()).getResultList();
            for(Posten p : postenList){
                if(kategorieMap.containsKey(p.getArtikel().getKategorie())){
                    kategorieMap.put(p.getArtikel().getKategorie(), kategorieMap.get(p.getArtikel().getKategorie()) + ((double)p.getMenge() * p.getPreis()));
                }else{
                    kategorieMap.put(p.getArtikel().getKategorie(), (double)p.getMenge() * p.getPreis());
                }
            }

        }


        GridPane pane = new GridPane();

        Label title = new Label(this.currentSelection);
        title.setStyle("-fx-font: 24 arial;");
        GridPane.setColumnSpan(title, 2);
        GridPane.setRowSpan(title, 2);
        GridPane.setHalignment(title, HPos.CENTER);
        pane.add(title, 0, 0 );


        Label headerKat = new Label("Kategorie");
        Label headerMoney = new Label("Ausgaben");

        GridPane.setHalignment(headerKat, HPos.CENTER);
        GridPane.setHalignment(headerMoney, HPos.CENTER);

        pane.add(headerKat, 0, 2);
        pane.add(headerMoney, 1, 2);

        int counter = 3;
        double gesamt = 0.0;
        final ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        Iterator it = kategorieMap.entrySet().iterator();
        while(it.hasNext()){

            Map.Entry<Kategorie, Double> entry = (Map.Entry<Kategorie, Double>) it.next();
            TextField kat = new TextField();
            kat.setEditable(false);
            kat.setText(entry.getKey().getName());

            TextField money = new TextField();
            money.setEditable(false);
            money.setText(new DecimalFormat("#######.##").format(entry.getValue()) + " €");
            money.setAlignment(Pos.CENTER_RIGHT);

            gesamt += entry.getValue();

            pane.add(kat,  0, counter);
            pane.add(money, 1, counter);
            data.add(new PieChart.Data(entry.getKey().getName(), entry.getValue()));
            ++counter;
        }



        VBox box = new VBox();
        Separator sep = new Separator();
        box.setMargin(sep, new Insets(10, 0, 10,0 ));
        box.getChildren().add(sep);

        GridPane.setColumnSpan(box, 2);
        GridPane.setConstraints(box, 0, counter + 2);
        pane.getChildren().add(box);


        Label headerGesamt = new Label("Gesamt");
        headerGesamt.setPadding(new Insets(0,0,0,10));
        GridPane.setHalignment(headerGesamt, HPos.LEFT);

        Label headerGesamtMoney = new Label(new DecimalFormat("#######.##").format(gesamt) + " €");
        headerGesamtMoney.setAlignment(Pos.CENTER_RIGHT);
        headerGesamtMoney.setUnderline(true);
        GridPane.setHalignment(headerGesamtMoney, HPos.RIGHT);

        pane.add(headerGesamt, 0, counter + 3);
        pane.add(headerGesamtMoney, 1, counter + 3 );

        final PieChart chart = new PieChart(data);
        chart.setTitle("Verteilung");
        GridPane.setColumnSpan(chart, 2);
        pane.add(chart, 0, counter + 5);

        this.scrollPaneDetail.setContent(pane);

    }


    private void initScrollPaneJahr(){

        this.jahrList = this.em.createQuery("from Jahr j").getResultList();

        TreeItem<String> root  = new TreeItem<>("Root");
        root.setExpanded(true);
        for(Jahr jahr : this.jahrList){
            TreeItem<String> jahrItem = new TreeItem<>(jahr.getJahr().toString());
            List<Monat> monatList = this.em.createQuery("from Monat m where m.jahr.id = " + jahr.getId()).getResultList();
            System.out.println("MonateFound:\t"+monatList.size());
            for(Monat monat : monatList){
                List<Bon> bonList = this.em.createQuery("from Bon b where b.monat.id = " + monat.getId()).getResultList();
                if(bonList.isEmpty()){
                    continue;
                }
                this.monatBonMap.put(monat.getName(), bonList);

                TreeItem<String> monatItem = new TreeItem<>(monat.getName());
                jahrItem.getChildren().add(monatItem);
            }
            System.out.println("Jahr " + jahr.getJahr() + " has # Children:\t" + jahrItem.getChildren().size());
            jahrItem.setExpanded(true);
            root.getChildren().add(jahrItem);
        }
        System.out.println("Jahre: "+this.jahrList.size()+"\t\tMonate:"+this.monatBonMap.size());
        this.treeViewJahr = new TreeView<>(root);
        this.treeViewJahr.setShowRoot(false);
        this.scrollPaneJahr.setContent(this.treeViewJahr);
        System.out.println("Children under root:\t"+root.getChildren().size());

    }

    @FXML
    public void showAddBon(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addBon.fxml"));
        Stage dialog = new Stage();
        BonController bonController = new BonController(this.em, dialog, this.stage);
        loader.setController(bonController);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Scene scene = new Scene(root);

        dialog.initOwner(stage);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("JavaFX and Maven");
        dialog.setScene(scene);
        dialog.showAndWait();

        initialize();
    }

}
