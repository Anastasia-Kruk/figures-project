package by.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Objects;

public class Smile extends Figure {
    private double radius;

    private Smile(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_SMILE, cx, cy, lineWidth, color);
    }

    public Smile(double cx, double cy, double lineWidth, Color color, double radius) {
        this(cx, cy, lineWidth, color);
        this.radius = radius < 50 ? 50 : radius;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.beginPath();
        gc.strokeOval(cx - radius, cy - radius, radius * 2, radius * 2);
        gc.strokeOval(cx - radius / 2, cy - radius / 2, radius / 6, radius / 3);
        gc.strokeOval(cx + radius / 3, cy - radius / 2, radius / 6, radius / 3);
        gc.arc(cx, cy + radius / 3, radius / 2, radius / 2, 180, 180);
        gc.closePath();
        gc.stroke();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Smile smile = (Smile) o;
        return Double.compare(smile.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Smile{");
        sb.append("cx=").append(cx);
        sb.append(", cy=").append(cy);
        sb.append(", lineWidth=").append(lineWidth);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}
