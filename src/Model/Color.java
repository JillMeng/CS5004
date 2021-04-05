package Model;

/**
 * This class represents a color status with RGB format.
 */
public class Color implements IStatus{
  private double red;
  private double green;
  private double blue;

  /**
   * Constructs a color status with given RGB.
   *
   * @param red the red component of the color
   * @param green the green component of the color
   * @param blue the blue component of the color
   */
  public Color (double red, double green, double blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * Returns the red component of the color status.
   *
   * @return the red component of the color status
   */
  public double getRed() {
    return red;
  }

  /**
   * Returns the green component of the color status.
   *
   * @return the green component of the color status
   */
  public double getGreen() {
    return green;
  }

  /**
   * Returns the blue component of the color status.
   *
   * @return the blue component of the color status
   */
  public double getBlue() {
    return blue;
  }

  @Override
  public String getCurrentStatus() {
    String str = "Color: (%.1f, %.1f, %.1f)";
    return String.format(str, red, green, blue);
  }
}
