package Model;

public class Rectangle extends AbstractIShape {
  public Rectangle(String name, ShapeType type, Position position,
                   double sizeX, double sizeY, Color color, int appearT, int disappearT) {
    super(name, type, position, sizeX, sizeY, color, appearT, disappearT);
  }

  //action list

  public Rectangle currentStatus(int Tick) {

  }

}
