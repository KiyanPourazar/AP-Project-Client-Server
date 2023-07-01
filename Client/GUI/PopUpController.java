package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PopUpController {

    @FXML
    private Button OKButton;

    @FXML
    private Text resultString;

    @FXML
    void OKPressed(ActionEvent event) {
        Stage stage=(Stage)OKButton.getScene().getWindow();
        stage.close();
    }

    public void setResult(String result){
        resultString.setText(result);
    }
}