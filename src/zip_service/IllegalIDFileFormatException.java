package zip_service;

/**
 * Created with IntelliJ IDEA.
 * User: Алина
 * Date: 14.08.12
 * Time: 18:33
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
