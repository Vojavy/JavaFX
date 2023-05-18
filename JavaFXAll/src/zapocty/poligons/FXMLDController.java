/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package zapocty.poligons;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;

/**
 * FXML Controller class
 *
 * @author sirst
 */
public class FXMLDController implements Initializable {

    @FXML
    private Polygon leftTr;
    @FXML
    private Polygon rightTr;
    @FXML
    private Polyline poliLine;
    @FXML
    private AnchorPane mainPane;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vymaz();
        leftTr.getPoints().addAll(new Double[]{0.0,0.0,0.0,mainPane.getHeight(),mainPane.getWidth()/3, mainPane.getHeight()/2});
        rightTr.getPoints().addAll(new Double[]{mainPane.getWidth(),0.0,mainPane.getWidth(),mainPane.getHeight(),mainPane.getWidth()*2/3,mainPane.getHeight()/2});
        poliLine.getPoints().addAll(new Double[]{0.0,mainPane.getHeight(),mainPane.getWidth()/3,mainPane.getHeight()/2,mainPane.getWidth()*2/3,mainPane.getHeight()/2, mainPane.getWidth(),mainPane.getHeight()});
        mainPane.getChildren().addAll(leftTr, rightTr, poliLine);
        
        mainPane.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->{
            if (event.getButton() == MouseButton.PRIMARY){
                vymaz();
                leftTr.getPoints().addAll(new Double[]{0.0,0.0,0.0,mainPane.getHeight(),event.getX(),event.getY()});
                rightTr.getPoints().addAll(new Double[]{mainPane.getWidth(),0.0,mainPane.getWidth(),mainPane.getHeight(),mainPane.getWidth()*2/3,mainPane.getHeight()/2});
                poliLine.getPoints().addAll(new Double[]{0.0,mainPane.getHeight(),mainPane.getWidth()/3,mainPane.getHeight()/2,mainPane.getWidth()*2/3,mainPane.getHeight()/2, mainPane.getWidth(),mainPane.getHeight()});
                mainPane.getChildren().addAll(leftTr, rightTr, poliLine);
       }
            if (event.getButton() == MouseButton.SECONDARY){
                
            }
        });
    }    
    
     void vymaz() {
        mainPane.getChildren().clear();
        mainPane.setStyle("-fx-background-color: FFFFD0;");
    }
    
    void changePos(Polygon poligon, double x, double y){
        
    }
}
