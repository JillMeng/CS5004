package Model;

public class Action<T extends IStatus> implements IAction {

  //private Shape shape;
  protected String target;
  protected String actionID;
  protected int startTick;
  protected int endTick;
  protected T startS;
  protected T endS;
  protected ActionType actionType;

  public Action(String target, String actionID, int startTick,
                int endTick, T startS, T endS, ActionType actionType) {
    this.target = target;
    this.actionID = actionID;
    this.startTick = startTick;
    this.endTick = endTick;
    this.startS = startS;
    this.endS = endS;
    this.actionType = actionType;
  }

  public String getTarget() {
    return target;
  }

  public String getActionID() {
    return actionID;
  }

  public int getStartTick() {
    return startTick;
  }

  public int getEndTick() {
    return endTick;
  }

  public T getStartS() {
    return startS;
  }

  public T getEndS() {
    return endS;
  }

  public ActionType getActionType() {
    return actionType;
  }

  //Shape R moves from (200.0,200.0) to (300.0,300.0) from t=10 to t=50
  //Shape C moves from (500.0,100.0) to (500.0,400.0) from t=20 to t=70

}

