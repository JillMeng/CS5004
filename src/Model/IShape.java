package Model;


public interface IShape {

  String getName();

  ShapeType getType();

  Position getPosition();

  Color getColor();

  Scale getScale();

  void setPosition(Position p);

  void setColor(Color c);

  void setScale(double height, double width);

  void addAction(Action action);

  AbstractIShape getCurrentShape(int tick);

}


