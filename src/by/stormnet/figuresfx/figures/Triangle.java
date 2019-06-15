package by.stormnet.figuresfx.figures;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Objects;

public class Triangle extends Figure {
    private double lenght;

    public Triangle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_TRIANGLE, cx, cy, lineWidth, color);
    }

    public Triangle(double cx, double cy, double lineWidth, Color color, double lenght) {
        this(cx, cy, lineWidth, color);
        this.lenght = lenght;
    }

    public double getLenght() {
        return lenght;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.beginPath();
        gc.moveTo(cx + lenght / 2, cy + ((Math.sqrt(Math.pow(lenght, 2) - Math.pow(lenght / 2, 2))) / 3));
        gc.lineTo(cx - lenght / 2, cy + ((Math.sqrt(Math.pow(lenght, 2) - Math.pow(lenght / 2, 2))) / 3));
        gc.lineTo(cx, cy - (2 * (Math.sqrt(Math.pow(lenght, 2) - Math.pow(lenght / 2, 2))) / 3));
        gc.closePath();
        gc.stroke();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.lenght, lenght) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lenght);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Triangle{");
        sb.append("lenght=").append(lenght);
        sb.append(", cx=").append(cx);
        sb.append(", cy=").append(cy);
        sb.append(", lineWidth=").append(lineWidth);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}
