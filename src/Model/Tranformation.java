package Model;

//Shape R moves from (200.0,200.0) to (300.0,300.0) from t=10 to t=50
//Shape C moves from (500.0,100.0) to (500.0,400.0) from t=20 to t=70
//Shape C changes color from (0.0,0.0,1.0) to (0.0,1.0,0.0) from t=50 to t=80
//Shape R scales from Width: 50.0, Height: 100.0 to Width: 25.0, Height: 100.0 from t=51 to t=70
//Shape R moves from (300.0,300.0) to (200.0,200.0) from t=70 to t=100

public interface Tranformation {
  void addShape(String name, ShapeType type, Position position,
                double sizeX, double sizeY, Color color,int appearT,int disappearT);

  void addMotion(String name, IMotion motion, int startTick, int endTick) {
  }

  Tranformation setMotion(String action);
  void GetShapeAtTick(int Tick);
}
