package by.stormnet.figuresfx.controller;

import by.stormnet.figuresfx.drawutils.Drawer;
import by.stormnet.figuresfx.exception.FigureException;
import by.stormnet.figuresfx.figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class MainScreenViewController implements Initializable {
    private static final Logger logger = Logger.getLogger(MainScreenViewController.class.getName());
    private Random random;
    private ArrayList<Figure> figures;

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        figures = new ArrayList<>(1);
        random = new Random(System.currentTimeMillis());
    }

    private void addFigure(Figure figure) {
        figures.add(figure);
    }

    private Figure createFigure(double x, double y) throws FigureException {
        Figure figure = null;

        switch (random.nextInt(4)) {
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x, y, random.nextInt(10), new Color(random.nextDouble(), random.nextDouble(), random.nextDouble(), 1), random.nextInt(100));
                break;
            case Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(x, y, random.nextInt(10), new Color(random.nextDouble(), random.nextDouble(), random.nextDouble(), 1), random.nextInt(100), random.nextInt(100));
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Triangle(x, y, random.nextInt(10), new Color(random.nextDouble(), random.nextDouble(), random.nextDouble(), 1), random.nextInt(200));
                break;
            case Figure.FIGURE_TYPE_SMILE:
                figure = new Smile(x, y, random.nextInt(10), Color.YELLOW, random.nextInt(100));
                break;
            default:
                throw new FigureException("Unknown figure");
        }
        logger.info(figure);
        return figure;
    }

    private void repaint() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Drawer<Figure> drawer = new Drawer<>(figures);
        drawer.draw(canvas.getGraphicsContext2D());
    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) {
        try {
            addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        } catch (FigureException e) {
            logger.error(e.getMessage());
        }
        repaint();
    }
}
