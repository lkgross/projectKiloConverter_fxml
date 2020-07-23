package bsu.comp152;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;

public class Controller {

    @FXML
    private TextField kiloTextField;
    @FXML
    private Label resultLabel;

    public void handleCalcButton(ActionEvent event) {
        // Get the kilometers.
        double kilometers = Double.parseDouble(kiloTextField.getText());

        // Convert the kilometers to miles.
        double miles = kilometers * 0.6214;

        // Display the results.
        resultLabel.setText(String.format("%,.2f miles", miles));
    }
}


