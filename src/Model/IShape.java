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

  double getSizeX();

  double getSizeY();

  int appearTime();

  int disappearTime();

  Position getPosition();

  Color getColor();

  void setPosition(Position p);

  /**
   * Scales the shape with given factor during a specific time interval.
   *
   * @param factor the given factor to scale the shape
   */
  void setScaleX(double factor);

  void setScaleY(double factor);

  /**
   * Changes the color of the shape to a given color during a specific time interval.
   *
   * @param c the color to change to
   */
  void setColor(Color c);

  //list
  void addAction(IAction action);

}


