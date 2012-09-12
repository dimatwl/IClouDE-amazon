package servlets;

import managers.ConfigManager;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Алина
 * Date: 14.08.12
 * Time: 16:46
 * Generates id for task
 */
public class IDGenerator {
  private static int maxIDLength = 8;

  private static String getZeroString(int count){
    StringBuilder str = new StringBuilder("");
    for (int i = 0; i < count; i++){
      str.append("0");
    }
    return str.toString();
  }

  /**
   * Generates id for next task
   * @return task id
   * @throws IllegalIDFileFormatException
   */
  public static String getNextID() throws IllegalIDFileFormatException{
    String currentID = "";
    try {
      BufferedReader in = new BufferedReader(new FileReader(ConfigManager.getConfigFileLocation()));
      currentID = in.readLine();
      in.close();
    } catch (IOException e) {
      throw new IllegalIDFileFormatException("Can`t read config file.");
    }

    Long id = new Long(currentID);
    id++;
    currentID = getZeroString(maxIDLength - id.toString().length()) + id.toString();

    try {
      FileWriter out = new FileWriter(ConfigManager.getConfigFileLocation());
      out.write(currentID);
      out.close();
    } catch (IOException e) {
      throw new IllegalIDFileFormatException("Can`t read config file.");
    }

    return currentID;
  }
}
