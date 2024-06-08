package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class PainterController {
    private double x, y;
    private final Rectangle eraser = new Rectangle(0, 0, 10, 10);

    @FXML
    private ColorPicker colorSelector;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private ToggleGroup tools;

    @FXML
    void initialize() {
        // Initialize the default tool to pen and color to black
        colorSelector.setValue(Color.BLACK);
        eraser.setFill(Color.WHITE);
        eraser.setStroke(Color.BLACK);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseClicked(MouseEvent event) {
        Shape shape;
        if (((RadioButton) tools.getSelectedToggle()).getText().equals("Eraser")) {
            shape = new Rectangle(event.getX() - 5, event.getY() - 5, 10, 10);
            shape.setFill(Color.WHITE);
        } else {
            shape = new Circle(event.getX(), event.getY(), 2, colorSelector.getValue());
        }
        drawingAreaPane.getChildren().add(shape);
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Line newLine = new Line(x, y, event.getX(), event.getY());
        if (((RadioButton) tools.getSelectedToggle()).getText().equals("Eraser")) {
            newLine.setStroke(Color.WHITE);
            newLine.setStrokeWidth(10);
            eraser.setX(event.getX() - 5);
            eraser.setY(event.getY() - 5);
        } else {
            newLine.setStroke(colorSelector.getValue());
            newLine.setStrokeWidth(2);
        }
        drawingAreaPane.getChildren().add(newLine);
        x = event.getX();
        y = event.getY();
    }

    @FXML
    void drawingAreaMouseMoved(MouseEvent event) {
        if (((RadioButton) tools.getSelectedToggle()).getText().equals("Eraser")) {
            eraser.setX(event.getX() - 5);
            eraser.setY(event.getY() - 5);
        }
        x = event.getX();
        y = event.getY();
    }

    @FXML
    void selectPen(ActionEvent event) {
        drawingAreaPane.getChildren().remove(eraser);
    }

    @FXML
    void selectEraser(ActionEvent event) {
        if (!drawingAreaPane.getChildren().contains(eraser)) {
            drawingAreaPane.getChildren().add(eraser);
        }
    }
}
