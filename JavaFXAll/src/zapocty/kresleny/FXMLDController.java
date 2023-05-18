/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package zapocty.kresleny;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseButton;
import static javafx.scene.input.MouseButton.PRIMARY;
import static javafx.scene.input.MouseButton.SECONDARY;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;

public class FXMLDController implements Initializable {

    @FXML
    private Button btnVymazat;
    @FXML
    private ColorPicker colorPickerObrys;
    @FXML
    private ColorPicker colorPickerVypln;
    @FXML
    private Slider sliderPrumer;
    @FXML
    private Pane pane;
    
    private double rectSize = 50;
    private double circSize = 50;
    private Color obrysColor = Color.BLACK;
    private Color vyplnColor = Color.RED;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        sliderPrumer.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                rectSize = newValue.doubleValue();
                circSize = newValue.doubleValue();
            }
        });        
        
        colorPickerObrys.valueProperty().addListener(new ChangeListener<Color>() {
            
            @Override
            public void changed(ObservableValue<? extends Color> ov, Color oldValue, Color newValue) {
                if (newValue!=null) {
                    obrysColor = newValue;
                }
            }
        });
        
        
        
        colorPickerVypln.valueProperty().addListener(new ChangeListener<Color>() {
            
            @Override
            public void changed(ObservableValue<? extends Color> ov, Color oldValue, Color newValue) {
                if (newValue != null) {
                    vyplnColor = newValue;
                }
            }
        });
        
        
        pane.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                
                switch (event.getButton()) {
                    
                    case PRIMARY:
                        Rectangle rect = new Rectangle(event.getX() - rectSize/2, event.getY() - rectSize/2, rectSize, rectSize);
                        rect.setFill(vyplnColor);
                        rect.setStroke(obrysColor);
                        pane.getChildren().add(rect);
                        
                        rect.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (event.getButton()==MouseButton.MIDDLE) {
                                    Alert.AlertType type = Alert.AlertType.CONFIRMATION;
                                    Alert alert = new Alert(type,"");
                                    alert.initModality(Modality.APPLICATION_MODAL);
                                    alert.getDialogPane().setHeaderText("Odstranit vybrany objekt?");
                                    Optional<ButtonType> result = alert.showAndWait();
                        
                                    if (result.get() == ButtonType.OK) {
                                        pane.getChildren().remove(event.getSource());
                                    } else if (result.get() == ButtonType.CANCEL) {
                                    }
                                }
                            }
                        });
                        
                        break;
                       
                    case SECONDARY:
                        Circle circ = new Circle(event.getX(),event.getY(), circSize/2);
                        circ.setFill(vyplnColor);
                        circ.setStroke(obrysColor);
                        pane.getChildren().add(circ);
                        
                        circ.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (event.getButton()==MouseButton.MIDDLE) {
                                    Alert.AlertType type = Alert.AlertType.CONFIRMATION;
                                    Alert alert = new Alert(type,"");
                                    alert.initModality(Modality.APPLICATION_MODAL);
                                    alert.getDialogPane().setHeaderText("Odstranit vybrany objekt?");
                                    Optional<ButtonType> result = alert.showAndWait();
                        
                                    if (result.get() == ButtonType.OK) {
                                        pane.getChildren().remove(event.getSource());
                                    } else if (result.get() == ButtonType.CANCEL) {
                                    }
                                }
                            }
                        });
                        
                        break;
                    
                    default:
                }
            }    
        });
    }    

    @FXML
    private void btnVymazatOnAction(ActionEvent event) {
        
        pane.getChildren().clear();
    }
}
