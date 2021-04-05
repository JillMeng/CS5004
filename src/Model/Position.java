package Model;

public class Position {
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

  public String toString() {
    String str = "(%f, %f)";
    return String.format(str, x, y);
  }
}