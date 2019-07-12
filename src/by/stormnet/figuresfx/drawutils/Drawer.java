package by.stormnet.figuresfx.drawutils;

import by.stormnet.figuresfx.figures.Figure;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Drawer<T extends Figure & Drawable> {
    ArrayList<Figure> figures;

    public Drawer(ArrayList<Figure> figures) {
        this.figures = figures;
    }

    public void draw(GraphicsContext gc) {
        for (Figure fig : figures) {
            fig.draw(gc);
        }
    }
}
