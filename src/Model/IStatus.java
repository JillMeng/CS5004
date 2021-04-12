package Model;

/**
 * This interface represents a status at a certain tick. It is a super-type for all status.
 */
public interface IStatus {

  /**
   * Get the current status of model.Color, model.Position, or model.Scale in a formatted string value.
   * @return a String value represents the current shape status.
   */
  String getCurrentStatus();

}
