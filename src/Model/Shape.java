package Model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class represents a shape that extends the AbstractIShape abstract class.
 */
public class Shape extends AbstractIShape {

  /**
   * Constructs a Shape using given name, shape type, position, size,
   * color, appear tick, and disappear tick.
   *
   * @param name the name id of the shape
   * @param type the type of the shape
   * @param position the position of the shape
   * @param size the size of the shape
   * @param color the color of the shape
   * @param appearT the appear tick of the shape
   * @param disappearT the disappear tick of the shape
   */
  public Shape(String name, ShapeType type, Position position, Scale size, Color color, int appearT, int disappearT) {
    super(name, type, position, size, color, appearT, disappearT);
  }


  //Shape C changes color from (0.0,0.0,1.0) to (0.0,1.0,0.0) from t=50 to t=80
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
        int timeDiff = tick - action.getStartTick();
        double ratio = (double) timeDiff / (double) (action.getEndTick() - action.getStartTick());
        switch (action.getActionType()) {
          case ChangeColor:
            Action<Color> actionColor = (Action<Color>) action;
            double currentR = ratio * (actionColor.getEndS().getRed()
                    - actionColor.getStartS().getRed()) + actionColor.getStartS().getRed();
            double currentB = ratio * (actionColor.getEndS().getBlue()
                    - actionColor.getStartS().getBlue()) + actionColor.getStartS().getBlue();
            double currentG = ratio * (actionColor.getEndS().getGreen()
                    - actionColor.getStartS().getGreen()) + actionColor.getStartS().getGreen();
            shapeCopy.setColor(new Color(currentR, currentB, currentG));
            break;
          case ChangePosition:
            Action<Position> actionPosition = (Action<Position>) action;
            double currentX = ratio * (actionPosition.getEndS().getX()
                    - actionPosition.getStartS().getX()) + actionPosition.getStartS().getX();
            double currentY = ratio * (actionPosition.getEndS().getY()
                    - actionPosition.getStartS().getY()) + actionPosition.getStartS().getY();
            Position currentPosition = new Position(currentX, currentY);
            shapeCopy.setPosition(currentPosition);
            break;
          case ChangeScale:
            Action<Scale> actionScale = (Action<Scale>) action;
            double currentHeight = ratio * (actionScale.getEndS().getHeight()
                    - actionScale.getStartS().getHeight()) + actionScale.getStartS().getHeight();
            double currentWidth = ratio * (actionScale.getEndS().getWidth()
                    - actionScale.getStartS().getHeight()) + actionScale.getStartS().getWidth();
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
