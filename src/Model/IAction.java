package Model;

public interface IAction <T> {

  String getTarget();

  String getActionID();

  int getStartTick();

  int getEndTick();

  T getStartS();

  T getEndS();

  ActionType getActionType();

}
