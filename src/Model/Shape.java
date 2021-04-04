package Model;

public interface Shape {

  //  Shapes:
//  Name: R
//  Type: rectangle
//  Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (1.0,0.0,0.0)
//  Appears at t=1
//  Disappears at t=100

  String getShapeName();

  ShapeType getType();

  double getSizeX();

  double getSizeY();

  int appearT();

  int disappearT();

  /**
   * Returns the position of the shape.
   *
   * @return the position of the shape
   */
  Position getPosition();

  /**
   * Returns the color of the shape.
   *
   * @return the color of the shape
   */
  Color getColor();

//  /**
//   * Returns the size of the shape.
//   *
//   * @return the size of the shape
//   */
//  double getSize();

  /**
   * Move the shape to a specific position during a specific time interval.
   *
   * @param p the position to move to
   * @param t the time interval of moving
   */
  void setPosition(Position p);

  /**
   * Scales the shape with given factor during a specific time interval.
   *
   * @param factor the given factor to scale the shape
   * @param t the time interval to scale the shape
   */
  void setScaleX(double factor);

  void setScaleY(double factor);
  /**
   * Changes the color of the shape to a given color during a specific time interval.
   *
   * @param c the color to change to
   * @param t the time interval to change the shape's color
   */
  void setColor(Color c);

  void setShape(ShapeType other);

}



}
