package Model;

public interface IShape {

  /**
   * Returns the name id of the shape.
   *
   * @return the name id of the shape
   */
  String getName();

  /**
   * Returns the type of the shape.
   *
   * @return the type of the shape
   */
  String getType();

  /**
   * Returns the x-position of the shape.
   *
   * @return the x-position of the shape
   */
  int getX();

  /**
   * Returns the y-position of the shape.
   *
   * @return the y-position of the shape
   */
  int getY();

  /**
   * Returns the width of the shape.
   *
   * @return the width of the shape
   */
  int getW();

  /**
   * Returns the height of the shape.
   *
   * @return the height of the shape
   */
  int getH();

  /**
   * Returns the red color-value of the shape.
   *
   * @return the red color-value of the shape
   */
  int getR();

  /**
   * Returns the green color-value of the shape.
   *
   * @return the green color-value of the shape
   */
  int getG();

  /**
   * Returns the blue color-value of the shape.
   *
   * @return the blue color-value of the shape
   */
  int getB();

  /**
   * Returns the appear time of the shape.
   *
   * @return the appear time of the shape
   */
  int getAppearT();

  /**
   * Returns the disappear time of the shape.
   *
   * @return the disappear time of the shape
   */
  int getDisappearT();

  /**
   * Returns the text output when creating the shape.
   *
   * @return the text output when creating the shape
   */
  String getCreateOutput();

  /**
   * Returns the text output of the time interval of the shape.
   *
   * @return the text output of the time interval of the shape
   */
  String getTimeOutput();

}
