package Model;

public class Scale implements IStatus{

  private double height;
  private double width;

  public Scale(double width, double height) {
    this.height = height;
    this.width = width;
  }

  public double getHeight() {
    return height;
  }

  public double getWidth() {
    return width;
  }


}
