package managers;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * Created with IntelliJ IDEA.
 * User: Алина
 * Date: 20.08.12
 * Time: 12:46
 * Represents object for getting config information (data location)
 */
public class ConfigManager {
  private static String dataBaseLocation = "D:\\DataBase";
  private static String configFileLocation = "D:\\DataBase\\config";
  private static String taskNameFileName = "task_name";
  private static String taskStatusFileName = "task_status";
  private static String taskInputDataFileName = "task_data";
  private static String taskLogsFileName = "logs";
  private static String taskRunResultFileName = "run";


  /**
   * Gets config file (file with current id) location
   * @return config file path
   */
  public static String getConfigFileLocation() {
    return configFileLocation;
  }

  /**
   * Gets task path by task id
   * @param ID - task id
   * @return task path
   */
  public static String getTaskLocationByID(String ID) {
    return dataBaseLocation + "\\" + ID;
  }

  /**
   * Gets task name file path by task id
   * @param ID - task id
   * @return task name path
   */
  public static String getTaskNameFileLocationByID(String ID){
    return dataBaseLocation + "\\" + ID + "\\" + taskNameFileName;
  }

  public static String getTaskProjectLocationByName(String ID, String projectName){
    return dataBaseLocation + "\\" + ID + "\\" + projectName;
  }

  /**
   * Gets task status file path by task id
   * @param ID - task id
   * @return task status file path
   */
  public static String getTaskStatusFileLocationByID(String ID) {
    return dataBaseLocation + "\\" + ID + "\\" + taskStatusFileName;
  }

  /**
   * Gets task input data file path by task id
   * @param ID - task id
   * @return task input data file path
   */
  public static String getTaskInputDataFileLocationByID(String ID) {
    return dataBaseLocation + "\\" + ID + "\\" + taskInputDataFileName;
  }

  /**
   * Gets task logs file path by task id
   * @param ID - task id
   * @return task logs file path
   */
  public static String getTaskLogsFileLocationByID(String ID) {
    return dataBaseLocation + "\\" + ID + "\\" + taskLogsFileName;
  }

  /**
   * Gets task run result file path by task id
   * @param ID - task id
   * @return task run result file path
   */
  public static String getTaskRunResultFileLocationByID(String ID) {
    return dataBaseLocation + "\\" + ID + "\\" + taskRunResultFileName;
  }
}
