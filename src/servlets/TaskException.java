package servlets;

/**
 * Created with IntelliJ IDEA.
 * User: Алина
 * Indicates illegal work with task (error during reading or writing task status, input data or task result)
 */
public class TaskException extends Exception {
  private String msg;

  public TaskException() {
    this.msg = null;
  }

  public TaskException(String msg) {
    this.msg = msg;
  }

  public String toString() {
    return msg;
  }
}
