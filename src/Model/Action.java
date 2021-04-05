package Model;

/**
 * This class represents an action that implements IAction interface.
 *
 * @param <T> status of action, including position, color and scale
 */
public class Action<T extends IStatus> implements IAction {

  private final String target;
  private final String actionID;
  private final int startTick;
  private final int endTick;
  private final T startStatus;
  private final T endStatus;
  private final ActionType actionType;

  /**
   * Constructs an action using target, action ID, start tick, end tick,
   * start status, end status and action type.
   *
   * @param target the name id of the target shape that act the action
   * @param actionID the action ID of the action
   * @param startTick the start tick of the action
   * @param endTick the end tick of the action
   * @param startStatus the start status of the action
   * @param endStatus the end status of the action
   * @param actionType the action type of the action
   */
  public Action(String target, String actionID, int startTick,
                int endTick, T startStatus, T endStatus, ActionType actionType) {
    if (target == null || actionID == null || startTick <0 || endTick < startTick) {
      throw new IllegalArgumentException("Invalid action entry.");
    }
    this.target = target;
    this.actionID = actionID;
    this.startTick = startTick;
    this.endTick = endTick;
    this.startStatus = startStatus;
    this.endStatus = endStatus;
    this.actionType = actionType;
  }

  @Override
  public String getTarget() {
    return target;
  }

  @Override
  public String getActionID() {
    return actionID;
  }

  @Override
  public int getStartTick() {
    return startTick;
  }

  @Override
  public int getEndTick() {
    return endTick;
  }

  @Override
  public T getStartS() {
    return startStatus;
  }

  @Override
  public T getEndS() {
    return endStatus;
  }

  @Override
  public ActionType getActionType() {
    return actionType;
  }

}

