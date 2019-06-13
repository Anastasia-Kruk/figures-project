package by.stormnet.figuresfx.controller;

import by.stormnet.figuresfx.figures.Circle;
import by.stormnet.figuresfx.figures.Figure;
import by.stormnet.figuresfx.figures.Rectangle;
import by.stormnet.figuresfx.figures.Triangle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class MainScreenViewController implements Initializable {
    private Random random;
    private Figure[] figures;

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("MainScreenViewController!");
        figures = new Figure[1];
        random = new Random(System.currentTimeMillis());
    }

    private void addFigure(Figure figure) {
        if (figures[figures.length - 1] == null) {
            figures[figures.length - 1] = figure;
            return;
        }
        Figure[] tmp = new Figure[figures.length + 1];
        int index = 0;
        for (; index < figures.length; index++) {
            tmp[index] = figures[index];
        }
        tmp[index] = figure;
        figures = tmp;
    }

    private Figure createFigure(double x, double y) {
        Figure figure = null;

        switch (random.nextInt(3)) {
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x, y, random.nextInt(10), Color.GREEN, random.nextInt(100));
                break;
            case Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(x, y, random.nextInt(10), Color.YELLOW, random.nextInt(100),random.nextInt(100));
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Triangle(x, y, random.nextInt(10), Color.RED, random.nextInt(200));
                break;
            default:
                System.out.println("Unknown figure type!");
                break;
        }
        return figure;
    }

    private void repaint() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (Figure figure : figures) {
            if (figure != null) {
                figure.draw(canvas.getGraphicsContext2D());
            }
        }
    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) {
        addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        repaint();
    }
}
