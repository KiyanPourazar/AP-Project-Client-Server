package GUI;

import javax.swing.JFrame;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindow extends Application{
    @Override
    public void start(Stage stage) throws Exception{
        Parent root=FXMLLoader.load(getClass().getResource("FXML/login.fxml"));
        stage.setTitle("Twitter");
        JFrame frame = new JFrame("Java Swing And JavaFX");  
        JFXPanel jfxPanel = new JFXPanel();  
        frame.add(jfxPanel);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void run(){
        launch();
    }
}