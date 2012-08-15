package zip_service;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Алина
 * Date: 14.08.12
 * Time: 16:46
 */
public class IDGenerator {
  private static String dbPath = "D:\\DataBase";
  private static String curIDFile = "D:\\DataBase\\config";
  private static int maxIDLength = 8;

  private static String getZeroString(int count){
    StringBuilder str = new StringBuilder("");
    for (int i = 0; i < count; i++){
      str.append("0");
    }
    return str.toString();
  }

  public static String getNextID() throws IllegalIDFileFormatException{
    String currentID = "";
    try {
      BufferedReader in = new BufferedReader(new FileReader(curIDFile));
      currentID = in.readLine();
      in.close();
    } catch (IOException e) {
      throw new IllegalIDFileFormatException("Can`t read config file.");
    }

    Long id = new Long(currentID);
    id++;
    currentID = getZeroString(maxIDLength - id.toString().length()) + id.toString();

    try {
      FileWriter out = new FileWriter(curIDFile);
      out.write(currentID);
      out.close();
    } catch (IOException e) {
      throw new IllegalIDFileFormatException("Can`t read config file.");
    }

    return currentID;
  }
}
