/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package zapocty.grafSinCos;

import com.sun.source.tree.BreakTree;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author sirst
 */
public class FXMLDController implements Initializable {

    @FXML
    private Button btnZobraz;
    @FXML
    private CheckBox sinCB;
    @FXML
    private CheckBox cosCB;
    @FXML
    private TextField pocetKrokuText;
    @FXML
    private AnchorPane mainPane;
    private LineChart<Number, Number> lineChart;
    int krok;
    XYChart.Series<Number, Number> sinSeries;
    XYChart.Series<Number, Number> cosSeries;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    

    @FXML
    private void btnZobrazOnAction(ActionEvent event) {
        
        try {
            krok = Integer.parseInt(pocetKrokuText.getText());
            } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Error! Not a number!");
            alert.showAndWait();
            return;
        }
        if (krok > 100 || krok < 5){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Error! Number not in bounds <5, 100>!");
            alert.showAndWait();
            return;
        }
        mainPane.getChildren().clear();
        NumberAxis axisX = new NumberAxis(-1.0, 1.0, 0.25);
        NumberAxis axisY = new NumberAxis(0.0,6.5,krok*0.01);
        axisX.setTickMarkVisible(true);
        axisY.setTickMarkVisible(true);
        
        lineChart = new LineChart<>(axisY,axisX);
        
        axisX.setLabel("Uhel[rad]");
        

        if (sinCB.isPressed()){
            for (int i = 0; i > 720 ; i += krok) { 
                sinSeries = new XYChart.Series<>();
                sinSeries.setName("Sin()");
                double y = Math.sin(Math.toRadians(i));
                sinSeries.getData().add(new XYChart.Data<>(i, y));
            }
        }
        if (cosCB.isPressed()){
            for (int i = 0; i > 720 ; i += krok) {               
                cosSeries = new XYChart.Series<>();
                cosSeries.setName("Cos()");
                double y = Math.cos(Math.toRadians(i));
                cosSeries.getData().add(new XYChart.Data<>(i, y));
                
            }    
        }
        
        lineChart.getData().addAll(sinSeries, cosSeries);
        mainPane.getChildren().add(lineChart);
    }
}
