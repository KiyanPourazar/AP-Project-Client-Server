package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class FollowerController {

    @FXML
    private Button backButton;

    @FXML
    private TextArea textField;

    @FXML
    void back(ActionEvent event) {
        
    }

    public void setTextField(String text){
        textField.setText(text);
    }
}
