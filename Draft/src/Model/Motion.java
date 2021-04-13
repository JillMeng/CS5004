package Model;

public class Motion implements IMotion {

  private String name;
  private int t1;
  private int x1;
  private int y1;
  private int w1;
  private int h1;
  private int r1;
  private int g1;
  private int b1;
  private int t2;
  private int x2;
  private int y2;
  private int w2;
  private int h2;
  private int r2;
  private int g2;
  private int b2;
  private String motionType;

  /**
   * Constructs an abstractMotion using given name and motionType.
   *
   * @param name shape's name id
   * @param motionType type of motion
   */
  public Motion(String name, String motionType) {
    this.name = name;
    this.motionType = motionType;
  }

  public Motion(String name,
                        int t1, int x1, int y1, int w1, int h1, int r1, int g1, int b1,
                        int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
    this.name = name;
    this.t1 = t1;
    this.x1 = x1;
    this.y1 = y1;
    this.w1 = w1;
    this.h1 = h1;
    this.r1 = r1;
    this.g1 = g1;
    this.b1 = b1;
    this.t2 = t2;
    this.x2 = x2;
    this.y2 = y2;
    this.w2 = w2;
    this.h2 = h2;
    this.r2 = r2;
    this.g2 = g2;
    this.b2 = b2;
  }

  @Override
  public String printMotion() {
    switch (this.motionType) {
      case "ChangePosition":
        return String.format("%s moves from (%d, %d) to (%d, %d) from time t=%d to t=%d)",
                this.name, x1, y1, x2, y2, t1, t2);
      case "ChangeColor":
        return String.format("%s changes from %s to %s from time t=%d to t=%d)",
                this.name, new java.awt.Color(r1, g1, b1), new java.awt.Color(r2, g2, b2), t1, t2);
      case "ChangeScale":
        if (w1 != w2) {
          return String.format("%s changes width from %d to %d from time t=%d to t=%d)",
                  this.name, w1, w2, t1, t2);
        }
        else if (h1 != h2) {
          return String.format("%s changes height from %d to %d from time t=%d to t=%d)",
                  this.name, h1, h2, t1, t2);
        }
        else {
          throw new IllegalArgumentException("No change in scale");
        }
      default:
        return "";
    }
  }

  @Override
  public String getMotionType() {
    return this.motionType;
  }

  @Override
  public String getShapeName() {
    return name;
  }

  @Override
  public int getT1() {
    return t1;
  }

  @Override
  public int getX1() {
    return x1;
  }

  @Override
  public int getY1() {
    return y1;
  }

  @Override
  public int getW1() {
    return w1;
  }

  @Override
  public int getH1() {
    return h1;
  }

  @Override
  public int getR1() {
    return r1;
  }

  @Override
  public int getG1() {
    return g1;
  }

  @Override
  public int getB1() {
    return b1;
  }

  @Override
  public int getT2() {
    return t2;
  }

  @Override
  public int getX2() {
    return x2;
  }

  @Override
  public int getY2() {
    return y2;
  }

  @Override
  public int getW2() {
    return w2;
  }

  @Override
  public int getH2() {
    return h2;
  }

  @Override
  public int getR2() {
    return r2;
  }

  @Override
  public int getG2() {
    return g2;
  }

  @Override
  public int getB2() {
    return b2;
  }

  @Override
  public IShape getTweening(int t) {
    int x = x1 * ((t2 - t) / (t2 - t1)) + x2 * ((t - t1) / (t2 - t1));
    int y = y1 * ((t2 - t) / (t2 - t1)) + y2 * ((t - t1) / (t2 - t1));
    int w = w1 * ((t2 - t) / (t2 - t1)) + w2 * ((t - t1) / (t2 - t1));
    int h = h1 * ((t2 - t) / (t2 - t1)) + h2 * ((t - t1) / (t2 - t1));
    int r = r1 * ((t2 - t) / (t2 - t1)) + r2 * ((t - t1) / (t2 - t1));
    int g = g1 * ((t2 - t) / (t2 - t1)) + g2 * ((t - t1) / (t2 - t1));
    int b = b1 * ((t2 - t) / (t2 - t1)) + b2 * ((t - t1) / (t2 - t1));
    IShape shape = new Shape(name, x, y, w, h, r, g, b);
    return shape;
  }
}
