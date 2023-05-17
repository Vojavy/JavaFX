/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zapocty.circles.RBClick;

import zapocty.circles.LBClick.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author sirst
 */
public class JavaFXrb extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLD.fxml"));
        Scene scene = new Scene(root);
        
        
        stage.setMinHeight(600);
        stage.setMinWidth(850);
        stage.setScene(scene);
        stage.setTitle("Zapocet: Streblychenko Andrii");
        stage.show();
    }
    
}
