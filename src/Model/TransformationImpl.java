package Model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TransformationImpl implements Tranformation{

  private HashMap<String, Shape> shapeList;
  private HashMap <String,IMotion> motionList;

  public TransformationImpl() {
    shapeList = new LinkedHashMap<>();
    motionList = new LinkedHashMap<>();
  }

  @Override
  public void addShape(String name, ShapeType type, Position position,
                       double sizeX, double sizeY, Color color,int appearT,int disappearT) {
    shapeList.put(name, new ShapeImpl(name,type,position,sizeX,sizeY,color,appearT,disappearT));
  }

  @Override
  public void addMotion(String name, IMotion motion, int startTick, int endTick) {
    motionList.put(name, new MotionImpl()) {
    }
  }


  @Override
  public Tranformation setMotion(String action) {

  }

  @Override
  public void GetShapeAtTick(int Tick) {

  }
}
