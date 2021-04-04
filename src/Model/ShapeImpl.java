package Model;

public class ShapeImpl implements Shape{

  private String name;
  private ShapeType type;
  private Position position;
  private double sizeX;
  private double sizeY;
  private Color color;
  private int appearT;
  private int disappearT;


  public ShapeImpl(String name, ShapeType type, Position position,
                       double sizeX, double sizeY, Color color, int appearT, int disappearT) {
    //Throw illegal arguments
    this.name = name;
    this.type = type;
    this.position = position;
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    this.color = color;
    this.appearT = appearT;
    this.disappearT = disappearT;
  }


  @Override
  public String getShapeName() {
    return name;
  }

  public ShapeType getType() {
    return type;
  }

  public double getSizeX() {
    return sizeX;
  }

  public double getSizeY() {
    return sizeY;
  }

  @Override
  public int appearT() {
    return appearT;
  }

  @Override
  public int disappearT() {
    return disappearT;
  }

  @Override
  public Position getPosition() {
    return this.position;
  }

  @Override
  public Color getColor() {
    return this.color;
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
  public void setShape(ShapeType other) {

  }

  //Shape R scales from Width: 50.0, Height: 100.0 to Width: 25.0, Height: 100.0 from t=51 to t=70
  @Override
  public void setScaleX(double factor) {
    this.sizeX = factor * sizeX;
  }

  @Override
  public void setScaleY(double factor) {
    this.sizeY = factor * sizeY;
  }
}
