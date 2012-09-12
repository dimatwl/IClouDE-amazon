package servlets;

/**
 * Created with IntelliJ IDEA.
 * User: Алина
 * Date: 14.08.12
 * Time: 18:33
 * Indicates illegal id file, error during reading or writing id file
 */
public class IllegalIDFileFormatException extends Exception {
  private String msg;

  public IllegalIDFileFormatException() {
    this.msg = null;
  }

  public IllegalIDFileFormatException(String msg) {
    this.msg = msg;
  }

  public String toString() {
    return msg;
  }
}
