package blexer.controller;

import blexer.model.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostenController {

    private EntityManager em;

    private Stage currentStage, parentStage;

    private LocalDate date;

    private Geschaeft geschaeft;

    private int currentRow = 0;

    @FXML
    GridPane gridPane;

    private ObservableList<Artikel> artikelList = FXCollections.observableArrayList();

    private List<Posten> postenList = new ArrayList<>();

    private List<TextField> mengenFelder = new ArrayList<>(), preisFelder = new ArrayList<>();
    private List<ComboBox> artikelBoxen = new ArrayList<>();


    public PostenController(EntityManager em, Stage currentStage, Stage parentStage, LocalDate date, Geschaeft geschaeft) {
        this.em = em;
        this.currentStage = currentStage;
        this.parentStage = parentStage;
        this.date = date;
        this.geschaeft = geschaeft;
    }


    @FXML
    public void initialize(){
        gridPane.setVgap(10);
        this.artikelList.addAll(em.createQuery("from Artikel a").getResultList());
        for(int i=0; i<10;++i){
            addPostenField();
        }

    }


    /**
     * Fügt eine weitere Zeile für einen weiteren Posten der GridPane hinzu.
     * "Neuer Posten" - Button muss weiter nach unten verschoben werden
     */
    private void addPostenField(){
        final GridPane postenPane = new GridPane();
        postenPane.setHgap(10.0);



        final HBox artikelBox = new HBox();
        final Label artikel = new Label("Artikel: ");

        final ComboBox artikelCombo = new ComboBox(this.artikelList);
        this.artikelBoxen.add(artikelCombo);
        final Button addArtikelButton = new Button();
        addArtikelButton.setText("+");
        addArtikelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addArtikel();
            }
        });
        artikelBox.getChildren().addAll(artikel, artikelCombo, addArtikelButton);
        postenPane.add(artikelBox, 0, 0);

        final HBox mengeBox = new HBox();
        final Label menge = new Label("Menge:");
        final TextField mengeField = new TextField();
        mengeField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    mengeField.setText(newValue.replaceAll("[^\\d]", ""));
                }

            }
        });
        this.mengenFelder.add(mengeField);
        mengeBox.getChildren().addAll(menge, mengeField);


        final HBox preisBox = new HBox();
        final Label preis = new Label("Preis:");
        final TextField preisField = new TextField();
        preisField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,2})?")) {
                    preisField.setText(oldValue);
                }
            }
        });
        this.preisFelder.add(preisField);
        preisBox.getChildren().addAll(preis, preisField);


        this.gridPane.add(postenPane, 0, currentRow);
        this.gridPane.add(mengeBox, 1, currentRow);
        this.gridPane.add(preisBox, 2, currentRow);
        ++currentRow;
    }

    /**
     * Ruft Fenster zum hinzufügen eines Artikels auf.
     * Danach wird ObservableList artikelList geupdatet, um Comboboxen zu updaten!
     */
    private void addArtikel(){
        System.out.println("Clicked!");

    }

    public void proceedArtikelListe(){
        final List<Posten> postenList = new ArrayList<>();
        Bon bon = new Bon();
        bon.setGeschaeft(geschaeft);
        bon.setMonat(Monat.getMonatByDate(date, em));
        System.out.println(bon.getMonat().toString());
        bon.setDate(Date.valueOf(date));
        bon = em.merge(bon);


        for(int i=0; i<artikelBoxen.size();++i){
            if(checkIfRowIsEmpty(i)){
                final Artikel art = (Artikel) artikelBoxen.get(i).getSelectionModel().getSelectedItem();
                final Integer menge = Integer.parseInt(mengenFelder.get(i).getText());
                final Double preis = Double.parseDouble(preisFelder.get(i).getText());
                final Posten posten = new Posten();
                posten.setArtikel(art);
                posten.setMenge(menge);
                posten.setPreis(preis);
                posten.setBon(bon);
                em.merge(posten);
            }
        }
        em.flush();
        currentStage.close();
    }

    private boolean checkIfRowIsEmpty(int index){
        final boolean artikelMissing = artikelBoxen.get(index).getSelectionModel().getSelectedItem() != null;
        final boolean mengeMissing = !mengenFelder.get(index).getText().isEmpty();
        final boolean preisMissing = !preisFelder.get(index).getText().isEmpty();
        return artikelMissing && mengeMissing && preisMissing;
    }

}
