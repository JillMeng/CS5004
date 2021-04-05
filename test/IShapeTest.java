import org.junit.Before;
import org.junit.Test;

import Model.Animation;
import Model.Color;
import Model.Position;
import Model.Rectangle;
import Model.IShape;
import Model.ShapeType;

public class IShapeTest {

  private IShape rectangle;
  private Animation shapes;


//  Shapes:
//  Name: R
//  Type: rectangle
//  Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (1.0,0.0,0.0)
//  Appears at t=1
//  Disappears at t=100
  @Before
  public void setup() {
    Position oriP = new Position(200.0, 200.0);
    Color oriC = new Color(1.0,0.0,0.0);
    rectangle = new Rectangle("R", ShapeType.RECTANGLE,
            oriP, 50.0,100.0, oriC,1,100);
  }

  @Test
  public void addShape() {
    shapes.addShape(rectangle.getName(),rectangle);
  }

  @Test


}
