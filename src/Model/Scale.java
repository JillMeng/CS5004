package Model;

/**
 * This class represents a scale status, including height and width.
 */
public class Scale implements IStatus{

  private double height;
  private double width;

  /**
   * Constructs a scale status with given width and height.
   *
   * @param width the width of the scale status
   * @param height the height of the scale status
   */
  public Scale(double width, double height) {
    this.height = height;
    this.width = width;
  }

  /**
   * Returns the height of the scale status.
   *
   * @return the height of the scale status
   */
  public double getHeight() {
    return height;
  }

  /**
   * Returns the width of the scale status.
   *
   * @return the width of the scale status
   */
  public double getWidth() {
    return width;
  }


}
