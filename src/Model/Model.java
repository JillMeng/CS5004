package Model;

import java.util.List;

public interface Model {

  /**
   * Adds shape to the shapes LinkedList.
   *
   * @param shape the shape to be added to the list
   * @throws IllegalArgumentException if the shape to be added is null
   */
  void addShape(Shape shape);

  void addMotion(Motion motion);

  List<AbstractIShape> getState(int tick);
}
