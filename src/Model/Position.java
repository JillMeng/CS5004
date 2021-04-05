package Model;

/**
 * This class represents a position status, with x-axis and y-axis.
 */
public class Position implements IStatus{
  private double x;
  private double y;

  /**
   * Constructs a position status with given x and y.
   *
   * @param x the x-axis position
   * @param y the y-axis position
   */
  public Position(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Returns the x-axis position of the position status.
   *
   * @return the x-axis position
   */
  public double getX() {
    return x;
  }

  /**
   * Returns the y-axis position of the position status.
   *
   * @return the y-axis position
   */
  public double getY() {
    return y;
  }

  @Override
  public String getCurrentStatus() {
    String str = "Position: (%.1f, %.1f)";
    return String.format(str, x, y);
  }
}