package Model;

/**
 * This interface represents an action. It is a super-type of all actions.
 *
 * @param <T> current status
 */
public interface IAction <T> {

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

  T getStartS();

  T getEndS();

  /**
   * Returns the action type of the action.
   *
   * @return the action type of the action
   */
  ActionType getActionType();

}
