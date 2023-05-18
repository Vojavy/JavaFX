/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zapocty.poligons;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author sirst
 */
public class JavaPoligon extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLD.fxml"));
        Scene scene = new Scene(root);
        
        stage.setMinHeight(650);
        stage.setMinWidth(800);
        stage.setScene(scene);
        stage.setTitle("Zapocet: Streblychenko Andrii");
        stage.show();
        
    }
    
}
