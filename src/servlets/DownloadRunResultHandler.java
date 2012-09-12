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
 * Time: 17:34
 * Handling all requests on "rest/getRunResult" URL: rest/getRunResult
 * Method: GET Required response: RunResult
 */

@Path("/getRunResult")
public class DownloadRunResultHandler {

  @GET
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public String getBuildLogs(@QueryParam("zipID") String taskID) {
    taskID = "00000001";

    Boolean result;
    String description;
    String runResult;

    try {
      Task task = new Task(taskID);
      if (task.getTaskStatus().equals(Task.TaskStatus.READY)) {
        result = true;
        description = "Run result successfully packed.";
        runResult = task.getTaskResultData();
      } else {
        result = true;
        description = "Run result not packed, task ID=" + taskID + " not ready.";
        runResult = "";
      }

    } catch (TaskException e) {
      result = false;
      description = e.getMessage();
      runResult = "";
    }

    return GSON.getInstance().toJson(new RunResultResponse(result, description, runResult));
  }
}


/**
 * Contains response information
 */

class RunResultResponse {
  private Boolean result;
  private String description;
  private String runResult;

  public RunResultResponse(Boolean result, String description, String runResult) {
    this.result = result;
    this.description = description;
    this.runResult = runResult;
  }
}
