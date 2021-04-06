package Model;

import java.util.LinkedList;
import java.util.List;

/**
 * This is an abstract superclass that hold common code and attributes for Shape.
 * This class implements IShape interface.
 */
public abstract class AbstractIShape implements IShape {

  protected String name;
  protected ShapeType type;
  protected Position position;
  protected Scale size;
  protected Color color;
  protected int appearT;
  protected int disappearT;
  protected List<Action> actions = new LinkedList<>();


  /**
   * Constructs an AbstractIShape using given name, shape type, position,
   * size, color, appear tick and disappear tick.
   *
   * @param name the name id of the shape
   * @param type the shape type of the shape
   * @param position the position of the shape
   * @param size the size of the shape
   * @param color the color of the shape
   * @param appearT the appear tick of the shape
   * @param disappearT the disappear tick of the shape
   */
  public AbstractIShape(String name, ShapeType type, Position position, Scale size,
                        Color color, int appearT, int disappearT) {
    if (name == null || appearT < 0 || disappearT < appearT) {
      throw new IllegalArgumentException("Shape object is invalid.");
    }
    this.name = name;
    this.type = type;
    this.position = position;
    this.size = size;
    this.color = color;
    this.appearT = appearT;
    this.disappearT = disappearT;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public ShapeType getType() {
    return type;
  }

  @Override
  public Position getPosition() {
    return position;
  }

  @Override
  public Color getColor() {
    return color;
  }

  @Override
  public Scale getScale() {
    return size;
  }


  @Override
  public void setPosition(Position p) {
    this.position = p;
  }

  @Override
  public void setColor(Color c) {
    this.color = c;
  }

  @Override
  public void setScale(double height, double width) {
    if (height < 0 || width < 0) {
      throw new IllegalArgumentException("Scale size cannot be negative");
    }
    this.size = new Scale(height, width);
  }


  public void addAction(Action action) {
    actions.add(action);
  }


  public Action getAction(int index) {
    return actions.get(index);
  }

  public int countAction() {
    return actions.size();
  }
}

