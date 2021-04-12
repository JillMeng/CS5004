package Model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class represents a shape that extends the model.AbstractIShape abstract class.
 */
public class Shape extends AbstractIShape {

  /**
   * Constructs a model.Shape using given name, shape type, position, size, color, appear tick, and
   * disappear tick.
   *
   * @param name       the name id of the shape
   * @param type       the type of the shape
   * @param position   the position of the shape
   * @param size       the size of the shape
   * @param color      the color of the shape
   * @param appearT    the appear tick of the shape
   * @param disappearT the disappear tick of the shape
   */
  public Shape(String name, ShapeType type, Position position, Scale size,
               Color color, int appearT, int disappearT) {
    super(name, type, position, size, color, appearT, disappearT);
  }

  /**
   * A helper method to calculate the tweening factor at a given tick.
   * @param start
   * @param end
   * @param startStatus
   * @param endStatus
   * @param tick
   * @return
   */
  public double tweenHelper(double start, double end, double startStatus, double endStatus, double tick) {
    return startStatus * (end-tick)/(end - start) + endStatus * (tick - start)/(end - start);
  }


  @Override
  public AbstractIShape getCurrentShape(int tick) {
    if (tick < appearT || tick > disappearT) {
      throw new IllegalArgumentException("model.Shape does not exist anymore.");
    }

    Shape shapeCopy = new Shape(name, type, position, size, color, appearT, disappearT);

    Map<String, List<Motion>> maps = motions.stream()
            .collect(Collectors.groupingBy(item -> item.getTarget() + "_" + item.getMotionType()));

    for (Motion motion : motions) {
      double tickCopy = Math.min(motion.getEndTick(), tick);
      if (tickCopy >= motion.getStartTick() && tickCopy <= motion.getEndTick()) {
        List<Motion> groupedMotions = maps.get(motion.getTarget() + "_" + motion.getMotionType());
        for (Motion checkMotion : groupedMotions) {
          if (motion.getActionID() != checkMotion.getActionID()) {
            if (motion.getStartTick() <= checkMotion.getEndTick()
                    && checkMotion.getStartTick() <= motion.getStartTick()) {
              throw new IllegalStateException("model.Action overlap.");
            }
          }
        }
//        double timeDiff = tickCopy - motion.getStartTick();
//        double ratio = (double) timeDiff / (double) (motion.getEndTick() - motion.getStartTick());
        switch (motion.getMotionType()) {
          case ChangeColor:
            Motion<Color> motionColor = (Motion<Color>) motion;

//            double currentR = ratio * (motionColor.getEndS().getRed()
//                    - motionColor.getStartS().getRed()) + motionColor.getStartS().getRed();
//            double currentG = ratio * (motionColor.getEndS().getGreen()
//                    - motionColor.getStartS().getGreen()) + motionColor.getStartS().getGreen();
//            double currentB = ratio * (motionColor.getEndS().getBlue()
//                    - motionColor.getStartS().getBlue()) + motionColor.getStartS().getBlue();

            double currentR = tweenHelper(motion.getStartTick(), motion.getEndTick(),
                    motionColor.getStartS().getRed(), motionColor.getEndS().getRed(), tick);

            double currentG = tweenHelper(motion.getStartTick(), motion.getEndTick(),
                    motionColor.getStartS().getGreen(), motionColor.getEndS().getGreen(), tick);

            double currentB = tweenHelper(motion.getStartTick(), motion.getEndTick(),
                    motionColor.getStartS().getBlue(), motionColor.getEndS().getBlue(), tick);

            shapeCopy.setColor(new Color(currentR, currentG, currentB));
            break;

          case ChangePosition:
            Motion<Position> motionPosition = (Motion<Position>) motion;

//            double currentX = ratio * (motionPosition.getEndS().getX()
//                    - motionPosition.getStartS().getX()) + motionPosition.getStartS().getX();
//            double currentY = ratio * (motionPosition.getEndS().getY()
//                    - motionPosition.getStartS().getY()) + motionPosition.getStartS().getY();

            double currentX = tweenHelper(motion.getStartTick(), motion.getEndTick(),
                    motionPosition.getStartS().getX(), motionPosition.getEndS().getX(), tick);
            double currentY = tweenHelper(motion.getStartTick(), motion.getEndTick(),
                    motionPosition.getStartS().getY(), motionPosition.getEndS().getY(), tick);

            Position currentPosition = new Position(currentX, currentY);
            shapeCopy.setPosition(currentPosition);
            break;

          case ChangeScale:
            Motion<Scale> motionScale = (Motion<Scale>) motion;
//            double currentHeight = ratio * (motionScale.getEndS().getHeight()
//                    - motionScale.getStartS().getHeight()) + motionScale.getStartS().getHeight();
//            double currentWidth = ratio * (motionScale.getEndS().getWidth()
//                    - motionScale.getStartS().getWidth()) + motionScale.getStartS().getWidth();

            double currentHeight = tweenHelper(motion.getStartTick(), motion.getEndTick(),
                    motionScale.getStartS().getHeight(), motionScale.getEndS().getHeight(), tick);
            double currentWidth = tweenHelper(motion.getStartTick(), motion.getEndTick(),
                    motionScale.getStartS().getWidth(), motionScale.getEndS().getWidth(), tick);

            shapeCopy.setScale(currentWidth, currentHeight);
            break;

          default:
            throw new IllegalArgumentException("Cannot perform action.");
        }
      }
    }
    return shapeCopy;
  }
}
