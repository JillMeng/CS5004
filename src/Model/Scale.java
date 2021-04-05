package Model;

public class Scale implements IStatus{

  private double height;
  private double width;

  public Scale(double height, double width) {
    this.height = height;
    this.width = width;
  }

  public double getHeight() {
    return height;
  }

  public double getWidth() {
    return width;
  }

//  public String toString() {
//    String str = "(%f, %f)";
//    return String.format(str, x, y);
//  }

}
