package Model;

public class MotionImpl implements IMotion{

  private Shape shape;
  private int startTick;
  private int endTick;

  public MotionImpl(Shape shape, int startTick, int endTick) {
    this.shape = shape;
    this.startTick = startTick;
    this.endTick = endTick;
  }

  public int getStartTick() {
    return startTick;
  }

  public int getEndTick() {
    return endTick;
  }

  @Override
  public void move(Position p) {

  }

  @Override
  public void changeColor(Color other) {

  }

  @Override
  public void changeShape(ShapeType other) {

  }

  @Override
  public void scaling(double factor) {

  }
}
