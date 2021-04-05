package Model;

public class Position implements IStatus{
  private double x;
  private double y;

  public Position(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  @Override
  public String getCurrentStatus() {
    String str = "Position: (%.1f, %.1f)";
    return String.format(str, x, y);
  }
}