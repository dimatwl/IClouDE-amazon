package servlets;

import managers.ConfigManager;
import managers.Task;
import managers.ZipManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Алина
 * Date: 07.08.12
 * Time: 17:59
 * Handling all requests on "rest/getBuildZip" URL: rest/getBuildZip
 * Method: GET Required response: zip file
 */

@Path("/getBuildZip")
public class DownloadBuildZipHandler {
  @GET
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public InputStream getBuildLogs(@QueryParam("getBuildZip") String taskID) {
    InputStream buildZip = null;
    taskID = "00000001";
    try {
      Task task = new Task(taskID);
      //buildZip = ZipManager.zipFile(ConfigManager.getTaskProjectLocationByName(taskID, task.getTaskProjectName()));

      buildZip = new FileInputStream(new File(ConfigManager.getTaskLocationByID(taskID)));


    } catch (FileNotFoundException e) {

    } catch (TaskException e){

    }
    return buildZip;
  }
}
