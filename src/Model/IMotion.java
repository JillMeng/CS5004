package Model;

/**
 * This interface represents an action. It is a super-type of all actions.
 *
 * @param <T> current status
 */
public interface IMotion<T> {


  /**
   * Returns the name id of the target shape that will act the action.
   *
   * @return the target shape's name id
   */
  String getTarget();

  /**
   * Returns the action ID of the action.
   *
   * @return the action ID of the action
   */
  String getActionID();

  /**
   * Returns the start tick of the action.
   *
   * @return the start tick of the action
   */
  int getStartTick();

  /**
   * Returns the end tick of the action.
   *
   * @return the end tick of the action
   */
  int getEndTick();

  /**
   * Returns the start status.
   *
   * @return the start status
   */
  T getStartS();

  /**
   * Returns the end status.
   *
   * @return the end status
   */
  T getEndS();

  /**
   * Returns the action type of the action.
   *
   * @return the action type of the action
   */
  MotionType getMotionType();

}
