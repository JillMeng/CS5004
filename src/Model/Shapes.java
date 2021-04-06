package Model;

import java.util.LinkedList;
import java.util.List;

/**
 * This class represents the shape list with all the shapes we add to the list.
 */
public class Shapes {

  private List<Shape> shapes;

  /**
   * Constructs a shape list and initialize it as a LinkedList.
   */
  public Shapes() {
    shapes = new LinkedList<>();
  }

  /**
   * Adds shape to the shapes LinkedList.
   *
   * @param shape the shape to be added to the list
   * @throws IllegalArgumentException if the shape to be added is null
   */
  public void addShape(Shape shape) {
    if (shape == null) {
      throw new IllegalArgumentException("Shape cannot be null");
    } else {
      shapes.add(shape);
    }
  }

  /**
   * Count the number of shape in the shape list.
   * @return an int value that represents the size of the list.
   */
  public int count() {
    return shapes.size();
  }

  /**
   * Get the Shape object with a given index.
   * @param index the index of the object in the list.
   * @return the specified Shape object.
   */
  public Shape getShape(int index) {
    return shapes.get(index);
  }

  /**
   * Gets states of each shape from the shapes LinkedList with their current states at a given tick,
   * including position, color, and scale, and add each current shape with current states into
   * a new shapesCopy list, and then returns the new list.
   *
   * @param tick the given tick used to get the current shape with current states
   * @return a new list containing shapes with their current states at the given tick
   */
  public void getState(int tick) {
//    List<Shape> shapesCopy = new LinkedList<>();
//    shapes.forEach(shape -> {
//      shapesCopy.add(shape);
//    });
    shapes.forEach(shape -> shape.getCurrentShape(tick));
  }
}