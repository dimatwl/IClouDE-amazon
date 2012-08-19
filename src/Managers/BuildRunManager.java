package Managers;

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

  public static final int BUILD = 1;
  public static final int RUN = 2;

  public static void build(int type) throws IOException, InterruptedException {
    Runtime runtime = Runtime.getRuntime();
    Process proc = null;

    if (type == BUILD) {
      proc = runtime.exec("C:\\Python22\\build.py");
    } else {
      proc = runtime.exec("run.sh");
    }

    Streamer err_stream = new Streamer(proc.getErrorStream());
    Streamer out_stream = new Streamer(proc.getInputStream());

    err_stream.run();
    out_stream.run();

    exit_value = proc.waitFor();
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
