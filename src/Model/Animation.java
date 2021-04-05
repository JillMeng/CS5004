package Model;

//Shape R moves from (200.0,200.0) to (300.0,300.0) from t=10 to t=50
//Shape C moves from (500.0,100.0) to (500.0,400.0) from t=20 to t=70
//Shape C changes color from (0.0,0.0,1.0) to (0.0,1.0,0.0) from t=50 to t=80
//Shape R scales from Width: 50.0, Height: 100.0 to Width: 25.0, Height: 100.0 from t=51 to t=70
//Shape R moves from (300.0,300.0) to (200.0,200.0) from t=70 to t=100

public interface Animation {

  /**
   * Adds a shape to the animation.
   *
   * @param name the name id of the shape to be added
   * @param IShape the shape to be added
   * @param time the Time interval of the shape
   * @throws IllegalArgumentException if the name id already existed in the list
   */
  void addShape(String name, IShape IShape) throws IllegalArgumentException;

  /**
   * Removes a shape from the animation.
   *
   * @param name the name id of the shape to be removed
   * @throws IllegalArgumentException if the name id doesn't exist in the list
   */
  void removeShape(String name) throws IllegalArgumentException;

  /**
   * Adds a motion to the animation.
   *
   * @param name the name id of the motion to be added
   * @param motion the motion to be added to the motion list
   * @throws IllegalArgumentException if the motion already existed in the list
   */
  void addMotion(String name, IAction motion) throws IllegalArgumentException;

  /**
   * Removes a motion from the animation.
   *
   * @param name the name id of the motion to be removed from the list
   * @throws IllegalArgumentException if the motion doesn't exist in the list
   */
  void removeMotion(String name) throws IllegalArgumentException;

  /**
   * Returns the current state of the animation.
   *
   * @param tick the time tick that we want to use to retrieve the state
   * @return the current state of the animation
   */
  Animation getState(int tick);

}
