package blexer.controller;

import blexer.model.Geschaeft;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class BonController {


    @FXML
    DatePicker datePicker;

    @FXML
    ComboBox geschaeftBox;

    private EntityManager em;

    private Stage parentStage, currentStage;

    public BonController(EntityManager em, Stage currentStage, Stage parentStage) {
        this.em = em;
        this.currentStage = currentStage;
        this.parentStage = parentStage;

    }

    @FXML
    public void initialize() {
        this.datePicker.setValue(LocalDate.now());
        fillComboBox();
    }

    private void fillComboBox(){
        final List<Geschaeft> geschaeftList = em.createQuery("from Geschaeft g").getResultList();
        ObservableList<Geschaeft> data = this.geschaeftBox.getItems();
        for(Geschaeft g : geschaeftList){
            data.add(g);
        }
        geschaeftBox.getSelectionModel().select(0);
    }

    @FXML
    public void handleWeiterButton(){
        final LocalDate date = this.datePicker.getValue();
        final Geschaeft geschaeft = (Geschaeft) this.geschaeftBox.getSelectionModel().getSelectedItem();
        System.out.println("Weiter!" + date +"\t"+ geschaeft.toString());

        openPostenListe(date, geschaeft);
    }

    private void openPostenListe(LocalDate date, Geschaeft geschaeft){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/postenList.fxml"));
        Stage dialog = new Stage();
        PostenController postenController = new PostenController(this.em, dialog, parentStage, date, geschaeft);
        loader.setController(postenController);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Scene scene = new Scene(root);
        dialog.initOwner(parentStage);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("");
        dialog.setScene(scene);
        dialog.showAndWait();
        this.currentStage.close();

    }
}
