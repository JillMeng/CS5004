import org.junit.Before;
import org.junit.Test;

import Model.Action;
import Model.ActionType;
import Model.Color;
import Model.Position;
import Model.Scale;
import Model.Shape;
import Model.ShapeType;

import static org.junit.Assert.assertEquals;

public class IShapeTest {

  private Shape rectangle;


//  Shapes:
//  Name: R
//  Type: rectangle
//  Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (1.0,0.0,0.0)
//  Appears at t=1
//  Disappears at t=100
  @Before
  public void setup() {
    Position oriP = new Position(200.0, 200.0);
    Color oriC = new Color(1.0, 0.0, 0.0);
    Scale oriS = new Scale(100.0,50.0);
    rectangle = new Shape("R",ShapeType.RECTANGLE,oriP,oriS,oriC,1,100);
  }

  //Shape R moves from (200.0,200.0) to (300.0,300.0) from t=10 to t=50
  //Shape R move from (200.0,200.0) to (300.0,300.0) from t=40 to t=90
  //Shape C changes color from (0.0,0.0,1.0) to (0.0,1.0,0.0) from t=50 to t=80
  @Test
  public void addActionTest() {
    rectangle.addAction(new Action<Position>("R", "Move1",10,50,
            new Position(200.0,200.0),new Position(300.0,300.0), ActionType.CHANGEPOSITION));
    rectangle.addAction(new Action<Position>("R", "Move2",30,90,
            new Position(300.0,300.0),new Position(500.0,300.0), ActionType.CHANGEPOSITION));
    rectangle.addAction(new Action<Color>("R", "ChangeColor1",51,80,
            new Color(0.0,0.0,1.0),new Color(0.0,1.0,0.0), ActionType.CHANGECOLOR));

    assertEquals(200.0, rectangle.getCurrentShape(10).getPosition().getX(),0.01);
    assertEquals(300.0, rectangle.getCurrentShape(60).getPosition().getY(),0.01);


  }
}
