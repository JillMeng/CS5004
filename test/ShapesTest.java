import org.junit.Before;
import org.junit.Test;

import Model.Action;
import Model.ActionType;
import Model.Color;
import Model.Position;
import Model.Scale;
import Model.Shape;
import Model.ShapeType;
import Model.Shapes;

import static org.junit.Assert.assertEquals;

public class ShapesTest {

  Shape rectangle;
  Shape oval;
  Shapes shapes;

  @Before
  public void setup() {
    shapes = new Shapes();

    Position oriP = new Position(200.0, 200.0);
    Color oriC = new Color(1.0, 0.0, 0.0);
    Scale oriS = new Scale(50.5, 100.0);
    rectangle = new Shape("R", ShapeType.RECTANGLE, oriP, oriS, oriC, 1, 100);

    Position oriP2 = new Position(500.0, 100.0);
    Color oriC2 = new Color(0.0, 0.0, 1.0);
    Scale oriS2 = new Scale(60.0, 30.0);
    oval = new Shape("C", ShapeType.OVAL, oriP2, oriS2, oriC2, 6, 100);
  }

  @Test
  public void addShapeTest() {
    shapes.addShape(rectangle);
    shapes.addShape(oval);

    assertEquals(2,shapes.count(),0.01);
    assertEquals(oval,shapes.getShape(1));
  }

  //Shape R moves from (200.0,200.0) to (300.0,300.0) from t=10 to t=50
  //Shape C moves from (500.0,100.0) to (500.0,400.0) from t=20 to t=70
  //Shape C changes color from (0.0,0.0,1.0) to (0.0,1.0,0.0) from t=50 to t=80
  //Shape R scales from Width: 50.0, Height: 100.0 to Width: 25.0, Height: 100.0 from t=51 to t=70
  //Shape R moves from (300.0,300.0) to (200.0,200.0) from t=70 to t=100
  @Test
  public void addActionTest() {
    rectangle.addAction(new Action<Position>("R", "Move1", 10, 50,
            new Position(200.0, 200.0),
            new Position(300.0, 300.0), ActionType.ChangePosition));
    rectangle.addAction(new Action<Scale>("R", "Scale1", 51, 70,
            new Scale(50, 100),
            new Scale(25, 100), ActionType.ChangeScale));
    rectangle.addAction(new Action<Position>("R", "Move2", 70, 100,
            new Position(300.0, 300.0),
            new Position(200.0, 200.0), ActionType.ChangePosition));

    oval.addAction(new Action<Position>("C", "Move1", 20, 70,
            new Position(500.0, 100.0),
            new Position(500.0, 400.0), ActionType.ChangePosition));
    oval.addAction(new Action<Color>("C", "ChangeColor1", 50, 80,
            new Color(0.0, 0.0, 1.0),
            new Color(0.0, 1.0, 0.0), ActionType.ChangeColor));

    assertEquals(250.0, rectangle.getCurrentShape(30).getPosition().getX(), 0.01);
    assertEquals(300.0, rectangle.getCurrentShape(60).getPosition().getX(), 0.01);
    assertEquals(300.0, rectangle.getCurrentShape(70).getPosition().getY(), 0.01);
    //assertEquals(250.0,rectangle.getCurrentShape(85).getPosition().getY(),0.01);
    assertEquals("Position: (300.0, 300.0)", rectangle.getCurrentShape(70).
            getPosition().getCurrentStatus());
    assertEquals("Scale: (50.5, 100.0)",
            rectangle.getCurrentShape(60).getScale().getCurrentStatus());
  }




}
