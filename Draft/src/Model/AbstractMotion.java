package Model;

public abstract class AbstractMotion implements IMotion {

  protected String name;
  protected int t1;
  protected int x1;
  protected int y1;
  protected int w1;
  protected int h1;
  protected int r1;
  protected int g1;
  protected int b1;
  protected int t2;
  protected int x2;
  protected int y2;
  protected int w2;
  protected int h2;
  protected int r2;
  protected int g2;
  protected int b2;
  protected String motionType;

  /**
   * Constructs an abstractMotion using given name and motionType.
   *
   * @param name shape's name id
   * @param motionType type of motion
   */
  public AbstractMotion(String name, String motionType) {
    this.name = name;
    this.motionType = motionType;
  }

  public AbstractMotion(String name,
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
}
