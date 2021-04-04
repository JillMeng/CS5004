package Model;

public class Move extends AbstractMotion {

  private Shape shape;
  private int startTick;
  private int endTick;

  public Move(Shape startShape, Shape endShape, int startTick, int endTick) {
    super(startShape, endShape, startTick, endTick);
  }
}
