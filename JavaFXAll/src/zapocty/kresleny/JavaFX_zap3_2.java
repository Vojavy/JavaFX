package zapocty.kresleny;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFX_zap3_2 extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLD.fxml"));
        Scene scene = new Scene(root);
        
        stage.setTitle("Zapocet: Streblychenko Andrii");
        stage.setScene(scene);
        stage.show();
    }
}
