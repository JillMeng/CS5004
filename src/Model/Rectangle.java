package Model;

public class Rectangle extends AbstractShape{
  public Rectangle(String name, ShapeType type, Position position,
                   double sizeX, double sizeY, Color color, int appearT, int disappearT) {
    super(name, type, position, sizeX, sizeY, color, appearT, disappearT);
  }

}
