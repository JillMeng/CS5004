package Model;

public class Move extends AbstractMotion {

  private Shape shape;
  private String name;
  private int startTick;
  private int endTick;
  private Position endP;

  public Move(Shape shape, String name, int startTick, int endTick, Position endP) {
    super(shape, name, startTick, endTick);
    this.endP = endP;
  }


  //Shape R moves from (200.0,200.0) to (300.0,300.0) from t=10 to t=50
 @Override
 public String getStatus() {
    String time = String.format("from t = %d to t = %", startTick,endTick);
    String str = "Shape" + name + "moves from"
            + shape.getPosition().toString()
            + "to" + endP.toString() + time;
    return str;
 }

}
