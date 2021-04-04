package Model;

public interface IMotion {

  //•	moveTo (Position other, startTick, endTick) :new ShapeImp
  //•	changeColor(Color other, startTick, endTick): new ShapeImp
  //•	scaling(factor, startTick, endTick): new ShapeImp

  void move(Position p);
  void changeColor(Color other);
  void changeShape(ShapeType other);
  void scaling(double factor);

}
