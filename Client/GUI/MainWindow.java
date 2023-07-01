package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindow extends Application{
    @Override
    public void start(Stage stage) throws Exception{
        Parent root=FXMLLoader.load(getClass().getResource("FXML\\login.fxml"));
        stage.setTitle("Twitter");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void run(){
        launch();
    }
}