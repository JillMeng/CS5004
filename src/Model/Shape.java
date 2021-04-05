package Model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Shape extends AbstractIShape {

  public Shape(String name, ShapeType type, Position position, Scale size,
               Color color, int appearT, int disappearT) {
    super(name, type, position, size, color, appearT, disappearT);
  }

  //this is a helper method to do the calculation.
  public double inBetween(int tick, int start, int end, double startValue, double endValue) {
    int timeDiff = tick - start;
    double ratio = (double) timeDiff / (double) (end - start);
    double currentValue = ratio * (endValue
            - startValue) + startValue;
    return currentValue;
  }

  @Override
  public AbstractIShape getCurrentShape(int tick) {
    Shape shapeCopy = new Shape(name, type, position, size, color, appearT, disappearT);

    Map<String, List<Action>> maps = actions.stream()
            .collect(Collectors.groupingBy(item -> item.getTarget() + "_" + item.getActionType()));

    for (Action action : actions) {
      tick = Math.min(action.getEndTick(), tick);
      if (tick >= action.getStartTick() && tick <= action.getEndTick()) {
        List<Action> groupedActions = maps.get(action.getTarget() + "_" + action.getActionType());
        for (Action checkAction : groupedActions)
          if (action.getActionID() != checkAction.getActionID()) {
            if (action.getStartTick() <= checkAction.getEndTick()
                    && checkAction.getStartTick() <= action.getStartTick()) {
              throw new IllegalArgumentException("Action overlap.");
            }
          }
//        int timeDiff = tick - action.getStartTick();
//        double ratio = (double) timeDiff / (double) (action.getEndTick() - action.getStartTick());
        switch (action.getActionType()) {
          case ChangeColor:
            Action<Color> actionColor = (Action<Color>) action;
            double currentR = inBetween(tick, action.getStartTick(), action.getEndTick(),
                    actionColor.getStartS().getRed(),actionColor.getEndS().getRed());
//            double currentR = ratio * (actionColor.getEndS().getRed()
//                    - actionColor.getStartS().getRed()) + actionColor.getStartS().getRed();

            double currentB = inBetween(tick, action.getStartTick(), action.getEndTick(),
                    actionColor.getStartS().getBlue(),actionColor.getEndS().getBlue());

//            double currentB = ratio * (actionColor.getEndS().getBlue()
//                    - actionColor.getStartS().getBlue()) + actionColor.getStartS().getBlue();

//            double currentG = ratio * (actionColor.getEndS().getGreen()
//                    - actionColor.getStartS().getGreen()) + actionColor.getStartS().getGreen();
            double currentG = inBetween(tick, action.getStartTick(), action.getEndTick(),
                  actionColor.getStartS().getGreen(),actionColor.getEndS().getGreen());
            shapeCopy.setColor(new Color(currentR, currentB, currentG));
            break;
          case ChangePosition:
            Action<Position> actionPosition = (Action<Position>) action;

            double currentX = inBetween(tick, action.getStartTick(), action.getEndTick(),
                    actionPosition.getStartS().getX(),actionPosition.getEndS().getX());

            double currentY = inBetween(tick, action.getStartTick(), action.getEndTick(),
                    actionPosition.getStartS().getY(),actionPosition.getEndS().getY());

//            double currentX = ratio * (actionPosition.getEndS().getX()
//                    - actionPosition.getStartS().getX()) + actionPosition.getStartS().getX();
//            double currentY = ratio * (actionPosition.getEndS().getY()
//                    - actionPosition.getStartS().getY()) + actionPosition.getStartS().getY();
            shapeCopy.setPosition(new Position(currentX, currentY));
            break;
          case ChangeScale:
            Action<Scale> actionScale = (Action<Scale>) action;

            double currentHeight = inBetween(tick, action.getStartTick(), action.getEndTick(),
                    actionScale.getStartS().getHeight(),actionScale.getEndS().getHeight());

            double currentWidth = inBetween(tick, action.getStartTick(), action.getEndTick(),
                    actionScale.getStartS().getWidth(),actionScale.getEndS().getWidth());

//            double currentHeight = ratio * (actionScale.getEndS().getHeight()
//                    - actionScale.getStartS().getHeight()) + actionScale.getStartS().getHeight();
//            double currentWidth = ratio * (actionScale.getEndS().getWidth()
//                    - actionScale.getStartS().getHeight()) + actionScale.getStartS().getWidth();
            shapeCopy.setScale(currentHeight, currentWidth);
            break;
          default:
            throw new IllegalArgumentException("Cannot perform action.");
        }
      }
    }
    return shapeCopy;
  }
}
