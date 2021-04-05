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



//  Shapes:
//  Name: R
//  Type: rectangle
//  Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (1.0,0.0,0.0)
//  Appears at t=1
//  Disappears at t=100

  public AbstractIShape(String name, ShapeType type, Position position, Scale size,
                        Color color, int appearT, int disappearT) {
    //Throw illegal arguments
    this.name = name;
    this.type = type;
    this.position = position;
    this.size = size;
    this.color = color;
    this.appearT = appearT;
    this.disappearT = disappearT;
  }

  public String getName() {
    return name;
  }

  public ShapeType getType() {
    return type;
  }

  public Scale getSize() {
    return size;
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
  public int appearTime() {
    return appearT;
  }

  @Override
  public int disappearTime() {
    return disappearT;
  }

  @Override
  public void setPosition(Position p) {
    this.position = p;
  }

  @Override
  public void setColor(Color c) {
    this.color = c;
  }

 //Shape R scales from Width: 50.0, Height: 100.0 to Width: 25.0, Height: 100.0 from t=51 to t=70
  @Override
  public void setScale(double height, double width) {
    this.size = new Scale (height, width);
  }

  @Override
  public void addAction(Action action) {
    actions.add(action);
  }
}

