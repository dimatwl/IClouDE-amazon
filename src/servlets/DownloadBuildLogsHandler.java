package servlets;

import managers.GSON;
import managers.Task;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: Алина
 * Date: 07.08.12
 * Time: 15:55
 * Handling all requests on "rest/getBuildLogs" URL: rest/getBuildLogs
 * Method: GET Required response: BuildLogs
 */


@Path("/getBuildLogs")
public class DownloadBuildLogsHandler {

  @GET
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public String getBuildLogs(@QueryParam("zipID") String taskID) {

    taskID = "00000001";

    Boolean result;
    String description;
    String buildLogs;

    try {
      Task task = new Task(taskID);
      if (task.getTaskStatus().equals(Task.TaskStatus.READY)) {
        result = true;
        description = "Build logs successfully packed.";
        buildLogs = task.getTaskResultData();
      } else {
        result = true;
        description = "Build logs not packed, task ID=" + taskID + " not ready.";
        buildLogs = "";
      }

    } catch (TaskException e) {
      result = false;
      description = e.getMessage();
      buildLogs = "";
    }

    return GSON.getInstance().toJson(new BuildLogsResponse(result, description, buildLogs));
  }
}


/**
 * Contains response information
 */

class BuildLogsResponse {
  private Boolean result;
  private String description;
  private String buildLogs;

  public BuildLogsResponse(Boolean result, String description, String buildLogs) {
    this.result = result;
    this.description = description;
    this.buildLogs = buildLogs;
  }
}