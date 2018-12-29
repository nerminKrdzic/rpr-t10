package ba.unsa.etf.rpr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class saveAsController {
    @FXML
     private ChoiceBox<String> choiceBox;

    @FXML
    public void initialize(){
        ObservableList<String> opcije = FXCollections.observableArrayList();
        opcije.addAll("PDF", "DOCX", "XSLX");
        choiceBox.setItems(opcije);
    }
}
