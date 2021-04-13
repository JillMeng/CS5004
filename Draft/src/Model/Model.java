package Model;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Model implements IModel {
  List<IShape> shapeList;
  List<IMotion> motionList;

  public Model() {
    shapeList = new LinkedList<>();
    motionList = new LinkedList<>();
  }

  @Override
  public void addShape(String name, String type) {
    IShape s = new Shape(name, type);
    for (int i = 0; i < shapeList.size(); i++) {
      if (name.equals(shapeList.get(i).getName())) {
        throw new IllegalArgumentException("Shape already existed.");
      }
      else {
        continue;
      }
    }
    shapeList.add(s);
  }

  @Override
  public void addMotion(String name, int t1, int x1, int y1, int w1, int h1, int r1, int g1,
                        int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
    IMotion m = new Motion(name, t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2, g2, b2);
    for (int i = 0; i < motionList.size(); i++) {
      if (motionList.get(i).getShapeName().equals(name)) {
        if (t2 > motionList.get(i).getT1() || t1 < motionList.get(i).getT2()) {
          throw new IllegalArgumentException("Action overlap.");
        }
      }
    }
    motionList.add(m);
  }

  @Override
  public String getStatusOutput() {
    String output = "";
    for (int i = 0; i < shapeList.size(); i++) {
      output = output + shapeList.get(i).getCreateOutput();
    }
    for (int i = 0; i < shapeList.size(); i++) {
      output = output + shapeList.get(i).getTimeOutput();
    }
    for (int i = 0; i < motionList.size(); i++) {
      output = output + motionList.get(i).printMotion();
    }
    return output;
  }

  @Override
  public List<IShape> getCurrentStatus(int t) {
    List<IShape> currentShapes = new LinkedList<>();
    for (int i = 0; i < motionList.size(); i++) {
      currentShapes.add(motionList.get(i).getTweening(t));
    }
    return currentShapes;
  }
}
