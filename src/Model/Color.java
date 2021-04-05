package Model;

public class Color implements IStatus{
  private double red;
  private double green;
  private double blue;

  public Color (double red, double green, double blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  public double getRed() {
    return red;
  }

  public double getGreen() {
    return green;
  }

  public double getBlue() {
    return blue;
  }

  @Override
  public String getCurrentStatus() {
    String str = "Color: (%.1f, %.1f, %.1f)";
    return String.format(str, red, green, blue);
  }
}
