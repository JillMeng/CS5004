package Model;

import java.awt.*;

public class Shape implements IShape {

  String name;
  String type;
  int x;
  int y;
  int w;
  int h;
  int r;
  int g;
  int b;
  int appearT;
  int disappearT;

  public Shape(String name, int x, int y, int w, int h, int r,
               int g, int b, int appearT, int disappearT) {
    this.name = name;
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.r = r;
    this.g = g;
    this.b = b;
    this.appearT = appearT;
    this.disappearT = disappearT;
  }

  public Shape(String name, int x, int y, int w, int h, int r,
               int g, int b) {
    this.name = name;
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * Constructs a shape using given name of shape and type of shape.
   *
   * @param name shape's name
   * @param type shape's type
   */
  public Shape(String name, String type) {
    this.name = name;
    this.type = type;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getType() {
    return this.type;
  }

  @Override
  public int getX() {
    return this.x;
  }

  @Override
  public int getY() {
    return this.y;
  }

  @Override
  public int getW() {
    return this.w;
  }

  @Override
  public int getH() {
    return this.h;
  }

  @Override
  public int getR() {
    return this.r;
  }

  @Override
  public int getG() {
    return this.g;
  }

  @Override
  public int getB() {
    return this.b;
  }

  @Override
  public int getAppearT() {
    return this.appearT;
  }

  @Override
  public int getDisappearT() {
    return this.disappearT;
  }

  @Override
  public String getCreateOutput() {
    String create = "";
    if (this.type.equals("rectangle")) {
      create = String.format("Create %s %s %s with corner at (%d, %d), "
                      + "width %d and height %d", new Color(this.r, this.g, this.b),
              this.type, this.name, this.x, this.y, this.w, this.h);
    }
    else if (this.type.equals("oval") || this.type.equals("eclipse")) {
      create = String.format("Create %s %s %s with center at (%d, %d), "
                      + "radius %d and %d", new Color(this.r, this.g, this.b),
              this.type, this.name, this.x, this.y, this.w, this.h);
    }
    return create;
  }

  @Override
  public String getTimeOutput() {
    String time = String.format("%s appears at time t=%d and disappears at time t=%d",
            this.name, this.appearT, this.disappearT);
    return time;
  }
}
