package Model;

public class Action<T extends IStatus> implements IAction {

  //private Shape shape;
  private String target;
  private int startTick;
  private int endTick;
  private T startS;
  private T endS;
  private ActionType actionType;

  public Action(String target, int startTick,
                int endTick, T startS, T endS, ActionType actionType) {
    this.target = target;
    this.startTick = startTick;
    this.endTick = endTick;
    this.startS = startS;
    this.endS = endS;
    this.actionType = actionType;
  }

  public String getTarget() {
    return target;
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

