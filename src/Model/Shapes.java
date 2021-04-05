package Model;

import java.util.LinkedList;
import java.util.List;

public class Shapes {

  private List<Shape> shapes;

  public Shapes() {
    shapes = new LinkedList<>();
  }

  public void addShape(Shape shape) {
    if (shape == null) {
      throw new IllegalArgumentException("Shape cannot be null");
    } else {
      shapes.add(shape);
    }
  }

  public int count() {
    return shapes.size();
  }

  public Shape getShape(int index) {
    return shapes.get(index);
  }

  public List<Shape> getState(int tick) {
    List<Shape> shapesCopy = new LinkedList<>();
    shapes.forEach(shape -> {
      shapesCopy.add(shape);
    });
    shapesCopy.forEach(shape -> shape.getCurrentShape(tick));
    return shapesCopy;
  }
}