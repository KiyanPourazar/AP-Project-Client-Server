package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class FollowerController {

    @FXML
    private TextArea textField;

    public void setTextField(String text){
        textField.setText(text);
    }
}
