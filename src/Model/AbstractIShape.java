package Model;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractIShape implements IShape {

  protected String name;
  protected ShapeType type;
  protected Position position;
  protected Scale size;
  protected Color color;
  protected int appearT;
  protected int disappearT;
  protected List<Action> actions = new LinkedList<>();


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

  @Override
  public void addAction(Action action) {
    actions.add(action);
  }
}

