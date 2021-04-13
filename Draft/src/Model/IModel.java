package Model;

import java.util.List;

public interface IModel {

  void addShape(String name, String type);

  void addMotion(String name,
                 int t1, int x1, int y1, int w1, int h1, int r1, int g1, int b1,
                 int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2);

  String getStatusOutput();

  List<IShape> getCurrentStatus(int t);

}
