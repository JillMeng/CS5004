package Model;

import java.util.List;

public interface IShape {

  //  Shapes:
//  Name: R
//  Type: rectangle
//  Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (1.0,0.0,0.0)
//  Appears at t=1
//  Disappears at t=100

  String getName();

  ShapeType getType();

  Position getPosition();

  void setPosition(Position p);

  void setColor(Color c);


  void setScale(double height, double width);

  void addAction(Action action);

  AbstractIShape getCurrentShape(int tick);

}


