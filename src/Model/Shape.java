package Model;



public class Shape extends AbstractIShape {


  public Shape(String name, ShapeType type, Position position, Scale size, Color color, int appearT, int disappearT) {
    super(name, type, position, size, color, appearT, disappearT);
  }

  //Shape C changes color from (0.0,0.0,1.0) to (0.0,1.0,0.0) from t=50 to t=80
  @Override
  public AbstractIShape getCurrentShape(int tick) {
    Shape shapeCopy = new Shape(name, type, position, size, color, appearT, disappearT);
    for (Action action : actions) {
      if (tick > action.getStartTick() && tick < action.getEndTick()) {
        int timeDiff = tick - action.getStartTick();
        double ratio = (double) timeDiff / (double) (action.getEndTick() - action.getStartTick());
        switch (action.getActionType()) {
          case CHANGECOLOR:
            Action<Color> actionColor = (Action<Color>) action;
            double currentR = ratio * (actionColor.getEndS().getRed()
                    - actionColor.getStartS().getRed()) + actionColor.getStartS().getRed();
            double currentB = ratio * (actionColor.getEndS().getBlue()
                    - actionColor.getStartS().getBlue()) + actionColor.getStartS().getBlue();
            double currentG = ratio * (actionColor.getEndS().getGreen()
                    - actionColor.getStartS().getGreen()) + actionColor.getStartS().getGreen();
            shapeCopy.setColor(new Color(currentR,currentB,currentG));
            break;
          case CHANGEPOSITION:
            Action<Position> actionPosition = (Action<Position>) action;
            double currentX = ratio * (actionPosition.getEndS().getX()
                    - actionPosition.getStartS().getX()) + actionPosition.getStartS().getX();
            double currentY = ratio * (actionPosition.getEndS().getY()
                    - actionPosition.getStartS().getY()) + actionPosition.getStartS().getY();
            Position currentPosition = new Position(currentX,currentY);
            shapeCopy.setPosition(currentPosition);
            break;
          case CHANGESCALE:
            Action<Scale> actionScale = (Action<Scale>) action;
            double currentHeight = ratio * (actionScale.getEndS().getHeight()
                    - actionScale.getStartS().getHeight()) + actionScale.getStartS().getHeight();
            double currentWidth = ratio * (actionScale.getEndS().getWidth()
                    - actionScale.getStartS().getHeight()) + actionScale.getStartS().getWidth();
            shapeCopy.setScale(currentHeight,currentWidth);
            break;
          default:
              throw new IllegalArgumentException("Cannot perform action.");
        }
      }
    }
    return shapeCopy;
  }
}
