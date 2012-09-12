package managers;

import servlets.TaskException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: Алина
 * Date: 15.08.12
 * Time: 14:11
 */
public class BuildRunManager {
  private static int exit_value;

  public static void execTask(Task task) throws TaskException{
    try {
      Runtime runtime = Runtime.getRuntime();
      Process proc = null;

      Task.TaskType type = task.getOPERATION();
      type = Task.TaskType.BUILD;

      if (type.equals(Task.TaskType.BUILD)) {
        proc = runtime.exec("python C:\\Python27\\build.py");
      } else
      if(type.equals(Task.TaskType.RUN)){
        proc = runtime.exec("python C:\\Python27\\run.py");
      } else
      if(type.equals(Task.TaskType.BUILD_RUN)){
        proc = runtime.exec("python C:\\Python27\\build_run.py");
      } else {
        throw  new TaskException("Task can not be exec, invalid task param.");
      }

      Streamer err_stream = new Streamer(proc.getErrorStream());
      Streamer out_stream = new Streamer(proc.getInputStream());

      err_stream.run();
      out_stream.run();

      exit_value = proc.waitFor();

    } catch (IOException e) {

    } catch (InterruptedException e) {

    }
  }

  public int getExitValue() {
    return exit_value;
  }
}

class Streamer extends Thread {
  private InputStream input;

  public Streamer(InputStream in) {
    input = in;
  }

  public void run() {
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(input));
      String line = null;

      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException ioe) {

    }
  }
}
