package Model;

public class Action<T extends IStatus> implements IAction {

  private final String target;
  private final String actionID;
  private final int startTick;
  private final int endTick;
  private final T startStatus;
  private final T endStatus;
  private final ActionType actionType;

  public Action(String target, String actionID, int startTick,
                int endTick, T startStatus, T endStatus, ActionType actionType) {
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

