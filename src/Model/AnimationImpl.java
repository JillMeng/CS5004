package Model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AnimationImpl implements Animation{

  private HashMap<String, Shape> shapeList;
  private HashMap <String,IMotion> motionList;

  public AnimationImpl() {
    shapeList = new LinkedHashMap<>();
    motionList = new LinkedHashMap<>();
  }

  @Override
  public void addShape(String name, Shape shape) {
    if (shapeList.containsKey(name)) {
      throw new IllegalArgumentException("Name ID already existed.");
    }
    else {
      shapeList.put(name, shape);
    }
  }


  @Override
  public void removeShape(String name) {
    if (!shapeList.containsKey(name)) {
      throw new IllegalArgumentException("No such name ID exists.");
    }
    else {
      shapeList.remove(name);
    }
  }

  @Override
  public void addMotion(String name, IMotion motion) {
    if (motionList.containsKey(name)) {
      throw new IllegalArgumentException("Name ID already existed.");
    }
    else {
      motionList.put(name, motion);
    }
  }

  @Override
  public void removeMotion(String name) {
    if (!motionList.containsKey(name)) {
      throw new IllegalArgumentException("No such name ID exists.");
    }
    else {
      motionList.remove(name);
    }
  }

  @Override
  public Animation getState(int tick) {
    return null;
  }
//
//  @Override
//  public Animation getState(int tick) {
//    return null;
//  }
}