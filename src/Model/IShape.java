package Model;

/**
 * This interface represents a shape. It is a super-type for all shapes.
 */
public interface IShape {

  /**
   * Returns the name of the shape.
   *
   * @return the name of the shape
   */
  String getName();

  /**
   * Returns the type of the shape.
   *
   * @return the type of the shape
   */
  ShapeType getType();

  /**
   * Returns the position of the shape.
   *
   * @return the position of the shape
   */
  Position getPosition();

  /**
   * Returns the Color of the shape.
   *
   * @return the color of the shape
   */
  Color getColor();

  /**
   * Returns the Scale of the shape.
   *
   * @return the scale of the shape
   */
  Scale getScale();

  /**
   * Sets the position of the shape using the given position.
   *
   * @param p the given position to set the position of the shape
   */
  void setPosition(Position p);

  /**
   * Sets the color of the shape using the given color.
   *
   * @param c the given color to set the color of the shape
   */
  void setColor(Color c);

  /**
   * Sets the scale of the shape using the given height and width.
   *
   * @param height the given height to be set
   * @param width  the given width to be set
   */
  void setScale(double height, double width);

  /**
   * Adds the given action to the action list.
   *
   * @param action the given action to be added to the action list
   */
  void addAction(Action action);

  /**
   * Returns the current shape with current position, current color and current scale at the given
   * tick.
   *
   * @param tick the current tick used to get current shape
   * @return the current shape with current position, current color and current scale at the given
   * tick
   */
  AbstractIShape getCurrentShape(int tick);

}


