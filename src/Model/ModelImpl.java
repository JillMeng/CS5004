package Model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class represents the shape list with all the shapes we add to the list.
 */
public class ModelImpl implements Model{

  private List<Shape> shapes;
  private List<Motion> motions;

  /**
   * Constructs a shape list and initialize it as a LinkedList.
   */
  public ModelImpl() {
    shapes = new LinkedList<>();
    motions = new LinkedList<>();
  }

  @Override
  public void addShape(Shape shape) {
      shapes.add(shape);
  }

  @Override
  public void addMotion(Motion motion) {
    motions.add(motion);
  }

  /**
   * Count the number of shape in the shape list.
   *
   * @return an int value that represents the size of the list.
   */
  public int count() {
    return shapes.size();
  }

  /**
   * Get the model.Shape object with a given index.
   *
   * @param index the index of the object in the list.
   * @return the specified model.Shape object.
   */
  public Shape getShape(int index) {
    return shapes.get(index);
  }

  /**
   * Gets states of each shape from the shapes LinkedList with their current states at a given tick,
   * including position, color, and scale, and add each current shape with current states into a new
   * shapesCopy list, and then returns the new list.
   *
   * @param tick the given tick used to get the current shape with current states
   * @return a new list containing shapes with their current states at the given tick
   */
  public List<AbstractIShape> getState(int tick) {
    List<AbstractIShape> shapesCopy = shapes.stream()
            .map(shape -> shape.getCurrentShape(tick)).collect(Collectors.toList());
    return shapesCopy;
  }
}