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
 * Date: 19.08.12
 * Time: 16:21
 * Handling all requests on "rest/checkTaskStatus" URL: rest/checkTaskStatus
 * Method: GET Required response: TaskStatus
 */

@Path("/checkTaskStatus")
public class CheckTaskStatusHandler {

  @GET
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public String getTaskStatus(@QueryParam("zipID") String taskID) {

    taskID = "00000001";

    Boolean result;
    String description;

    try {
      Task task = new Task(taskID);
      if (task.getTaskStatus().equals(Task.TaskStatus.READY)) {
        result = true;
        description = "Task is ready.";
      } else {
        result = true;
        description = "Task is not ready.";
      }

    } catch (TaskException e) {
      result = false;
      description = e.getMessage();
    }

    return GSON.getInstance().toJson(new CheckTaskStatusResponse(result, description));
  }
}

/**
 * Contains response information
 */

class CheckTaskStatusResponse {
  private Boolean result;
  private String description;

  public CheckTaskStatusResponse(Boolean result, String description) {
    this.result = result;
    this.description = description;
  }
}
