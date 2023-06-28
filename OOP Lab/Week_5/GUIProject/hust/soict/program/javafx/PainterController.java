package hust.soict.program.javafx;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javafx.event.ActionEvent;


public class PainterController {
    private boolean pen;
    private boolean eraser;
    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if (event.getX() <= 0 || event.getY() <= 0) return;
        if (pen) {
            Circle pen = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
            drawingAreaPane.getChildren().add(pen);
        } else if (eraser) {
            Circle pen = new Circle(event.getX(), event.getY(), 8, Color.WHITE);
            drawingAreaPane.getChildren().add(pen);
        }
    }

    @FXML
    void setPen(ActionEvent event) {
        pen = true;
        eraser = false;
    }

    @FXML
    void setEraser(ActionEvent event) {
        pen = false;
        eraser = true;
    }

}
