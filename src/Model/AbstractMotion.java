package Model;

public abstract class AbstractMotion implements IMotion{

  private Shape shape;
  private String name;
  private int startTick;
  private int endTick;

  public AbstractMotion(Shape shape, String name, int startTick, int endTick) {
    this.shape = shape;
    this.name = name;
    this.startTick = startTick;
    this.endTick = endTick;
  }

  public String getName() {
    return name;
  }

  public int getStartTick() {
    return startTick;
  }

  public int getEndTick() {
    return endTick;
  }



  //Shape R moves from (200.0,200.0) to (300.0,300.0) from t=10 to t=50
  //Shape C moves from (500.0,100.0) to (500.0,400.0) from t=20 to t=70

}

