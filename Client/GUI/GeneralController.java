package GUI;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GeneralController {
    public void showResult(String result){
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML/popup.fxml"));
            Parent root = loader.load();
            PopUpController popUpController = loader.getController();
            popUpController.setResult(result);
            Stage stage=new Stage();
            stage.setTitle("Result");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.exit(-1);
        }
    }

    public void setScene(Button button, String address){
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(address));
            button.getScene().setRoot(root);
        } catch (IOException e) {
            System.exit(-1);
        }
    }
}
