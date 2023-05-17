/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package zapocty.circles.RBClick;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 * FXML Controller class
 *
 * @author sirst
 */
public class FXMLDController implements Initializable {

    @FXML
    private AnchorPane hlavniPanelPane;
    @FXML
    private Button uckoncitAplikacebtn;
    @FXML
    private Button vymazatbtn;
    @FXML
    private ColorPicker barvaone;
    @FXML
    private ColorPicker barvatwo;
    Color oneCol, twoCol;
    private double currentRadius = 10;
    int pozX, pozY;
    boolean colorPick = true;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Line line1 = new Line(0, 0, hlavniPanelPane.getWidth(), hlavniPanelPane.getHeight());
        Line line2 = new Line(0, hlavniPanelPane.getHeight(), hlavniPanelPane.getWidth(), 0);

        line1.setStroke(Color.BLACK);
        line2.setStroke(Color.BLACK);
        hlavniPanelPane.getChildren().addAll(line1, line2);

        hlavniPanelPane.widthProperty().addListener((observable, oldValue, newValue) -> {
            vymaz();
        });

        hlavniPanelPane.heightProperty().addListener((observable, oldValue, newValue) -> {
            vymaz();
        });

        hlavniPanelPane.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                double x = event.getX();
                double y = event.getY();
                draw(x, y);
            }
        });

    }

    @FXML
    private void onMouseClickListener(MouseEvent event) {

    }

    @FXML
    private void uckoncitAplikacebtnOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void vymazatbtnOnAction(ActionEvent event) {
        vymaz();
    }

    @FXML
    private void barvaoneonaction(ActionEvent event) {
        oneCol = barvaone.getValue();
    }

    @FXML
    private void barvatwoonaction(ActionEvent event) {
        twoCol = barvatwo.getValue();
    }

    void vymaz() {
        hlavniPanelPane.getChildren().clear();
        hlavniPanelPane.setStyle("-fx-background-color: FFFFD0;");
        Line line1 = new Line(0, 0, hlavniPanelPane.getWidth(), hlavniPanelPane.getHeight());
        Line line2 = new Line(0, hlavniPanelPane.getHeight(), hlavniPanelPane.getWidth(), 0);
        hlavniPanelPane.getChildren().addAll(line1, line2);
    }

    void draw(double x, double y) {
        if (pozY == (int) y && pozX == (int) x) {
            if (x - currentRadius - 11>= 0 && y - currentRadius - 11>= 0 && x + currentRadius + 11<= hlavniPanelPane.getWidth() && y + currentRadius + 11<= hlavniPanelPane.getHeight()) {
                currentRadius += 10;
                Circle circle = new Circle(x, y, currentRadius);

                if (colorPick) {
                    circle.setStroke(oneCol);
                } else {
                    circle.setStroke(twoCol);
                }
                circle.setFill(Color.TRANSPARENT);

                hlavniPanelPane.getChildren().add(circle);

            }
        } else {
            if ( x - 11 >= 0 && y - 11 >= 0 && x + 11 <= hlavniPanelPane.getWidth() && y + 11 <= hlavniPanelPane.getHeight()) {
                colorPick = true;
                currentRadius = 10;
                Circle circle = new Circle(x, y, currentRadius);

                if (colorPick) {
                    circle.setStroke(oneCol);
                } else {
                    circle.setStroke(twoCol);
                }
                circle.setFill(Color.TRANSPARENT);
                hlavniPanelPane.getChildren().add(circle);
                pozX = (int) x;
                pozY = (int) y;
            }
        }
        colorPick = !colorPick;
    }

}
