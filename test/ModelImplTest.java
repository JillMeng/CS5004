import org.junit.Before;
import org.junit.Test;

import java.util.List;

import Model.AbstractIShape;
import Model.ModelImpl;
import Model.Motion;
import Model.MotionType;
import Model.Color;
import Model.Position;
import Model.Scale;
import Model.Shape;
import Model.ShapeType;

import static org.junit.Assert.assertEquals;

/**
 * A Junit test to test the public methods that take in user-input data.
 */
public class ModelImplTest {

  Shape rectangle;
  Shape oval;
  ModelImpl modelImpl;

  @Before
  public void setup() {
    modelImpl = new ModelImpl();

    Position oriP = new Position(200.0, 200.0);
    Color oriC = new Color(1.0, 0.0, 0.0);
    Scale oriS = new Scale(50.5, 100.0);
    rectangle = new Shape("R", ShapeType.RECTANGLE, oriP, oriS, oriC, 1, 100);

    Position oriP2 = new Position(500.0, 100.0);
    Color oriC2 = new Color(0.0, 0.0, 1.0);
    Scale oriS2 = new Scale(60.0, 30.0);
    oval = new Shape("C", ShapeType.OVAL, oriP2, oriS2, oriC2, 6, 100);

    modelImpl.addShape(rectangle);
    modelImpl.addShape(oval);

    rectangle.addAction(new Motion<Position>("R", "Move1", 10, 50,
            new Position(200.0, 200.0),
            new Position(300.0, 300.0), MotionType.ChangePosition));
    rectangle.addAction(new Motion<Scale>("R", "Scale1", 51, 70,
            new Scale(50, 100),
            new Scale(25, 100), MotionType.ChangeScale));
    rectangle.addAction(new Motion<Position>("R", "Move2", 70, 100,
            new Position(300.0, 300.0),
            new Position(200.0, 200.0), MotionType.ChangePosition));

    oval.addAction(new Motion<Position>("C", "Move1", 20, 70,
            new Position(500.0, 100.0),
            new Position(500.0, 400.0), MotionType.ChangePosition));
    oval.addAction(new Motion<Color>("C", "ChangeColor1", 50, 80,
            new Color(0.0, 0.0, 1.0),
            new Color(0.0, 1.0, 0.0), MotionType.ChangeColor));
  }

  @Test
  public void addActionTest() {
    rectangle.addAction(new Motion<Position>("R", "Move3", 51, 70,
            new Position(300.0, 300.0),
            new Position(500.0, 500.0), MotionType.ChangePosition));

    assertEquals(4, rectangle.countAction());
    assertEquals("Move3", rectangle.getAction(3).getActionID());
  }


  @Test
  public void addShapeTest() {
    assertEquals(2, modelImpl.count(), 0.01);
    assertEquals(oval, modelImpl.getShape(1));
  }

  @Test
  public void getCurrentShapeTest() {

    assertEquals(250.0, rectangle.getCurrentShape(30).getPosition().getX(), 0.01);
    assertEquals(300.0, rectangle.getCurrentShape(60).getPosition().getX(), 0.01);
    assertEquals(300.0, rectangle.getCurrentShape(70).getPosition().getY(), 0.01);
    assertEquals(250.0, rectangle.getCurrentShape(85).getPosition().getY(), 0.01);
    assertEquals("model.Position: (300.0, 300.0)", rectangle.getCurrentShape(70)
            .getPosition().getCurrentStatus());
    assertEquals("model.Scale: (38.2, 100.0)",
            rectangle.getCurrentShape(60).getScale().getCurrentStatus());


    assertEquals("model.Position: (500.0, 250.0)", oval.getCurrentShape(45)
            .getPosition().getCurrentStatus());
    assertEquals(100.0, oval.getCurrentShape(10).getPosition().getY(), 0.01);
    assertEquals(400.0, oval.getCurrentShape(75).getPosition().getY(), 0.01);
    assertEquals("model.Color: (0.0, 0.5, 0.5)", oval.getCurrentShape(65).getColor().getCurrentStatus());
    assertEquals("model.Color: (0.0, 1.0, 0.0)", oval.getCurrentShape(85).getColor().getCurrentStatus());
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidNegativeTime() {
    rectangle.getCurrentShape(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidTooLargeTime() {
    rectangle.getCurrentShape(101);
  }

  @Test(expected = IllegalStateException.class)
  public void actionPositionOverlap() {
    rectangle.addAction(new Motion<Position>("R", "Move4", 60, 95,
            new Position(300.0, 300.0),
            new Position(500.0, 500.0), MotionType.ChangePosition));
    assertEquals("Move4", rectangle.getAction(3).getActionID());
    rectangle.getCurrentShape(75).getPosition().getCurrentStatus();
  }


  @Test(expected = IllegalStateException.class)
  public void actionChangeColorOverlap() {
    oval.addAction(new Motion<Color>("C", "ChangeColor2", 70, 95,
            new Color(0.0, 0.5, 0.5),
            new Color(1.0, 2.5, 0.5), MotionType.ChangeColor));
    assertEquals("ChangeColor2", oval.getAction(2).getActionID());
    oval.getCurrentShape(75).getPosition().getCurrentStatus();
  }

  @Test(expected = IllegalStateException.class)
  public void actionScaleOverlap() {
    rectangle.addAction(new Motion<Scale>("R", "Scale2", 20, 60,
            new Scale(50.0, 100.0),
            new Scale(100.0, 200.0), MotionType.ChangeScale));
    assertEquals("Scale2", rectangle.getAction(3).getActionID());
    rectangle.getCurrentShape(52).getPosition().getCurrentStatus();
  }


  @Test
  public void getStateTest() {
    List<AbstractIShape> newShapes = modelImpl.getState(65);
    assertEquals("model.Color: (0.0, 0.5, 0.5)", newShapes.get(1).getColor().getCurrentStatus());
    assertEquals("model.Position: (500.0, 370.0)", newShapes.get(1).getPosition().getCurrentStatus());
    assertEquals("model.Scale: (60.0, 30.0)", newShapes.get(1).getScale().getCurrentStatus());

    List<AbstractIShape> newShapes2 = modelImpl.getState(80);
    assertEquals("model.Color: (1.0, 0.0, 0.0)", newShapes2.get(0).getColor().getCurrentStatus());
    assertEquals("model.Position: (266.7, 266.7)", newShapes2.get(0).getPosition().getCurrentStatus());
    assertEquals("model.Scale: (25.0, 100.0)", newShapes2.get(0).getScale().getCurrentStatus());
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidTick() {
    List<AbstractIShape> newShapes = modelImpl.getState(105);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidTime() {
    List<AbstractIShape> newShapes = modelImpl.getState(2);
  }
}
