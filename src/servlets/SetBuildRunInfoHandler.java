package servlets;

import managers.BuildRunManager;
import managers.GSON;
import managers.Task;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: Алина
 * Date: 08.08.12
 * Time: 16:44
 * Handling all requests on "rest/setBuildRunInfo" URL: rest/setBuildRunInfo
 * Method: POST Required response: SetInfoResult
 */

@Path("/setBuildRunInfo")
public class SetBuildRunInfoHandler {

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public String setBuildRunInfo(@FormParam("zipID") String taskID,
                                @FormParam("languageType") String languageType,
                                @FormParam("operation") String operation,
                                @FormParam("compileParameters") String compileParameters,
                                @FormParam("inputData") String inputData,
                                @FormParam("entryPointPath") String entryPointPath,
                                @FormParam("compilator") String compilator) {

    taskID = "00000001";

    Boolean result;
    String description;

    try {
      Task task = new Task(taskID);
      task.setTaskInputData(languageType, operation, compileParameters,
                            inputData, entryPointPath, compilator);
      task.setTaskStatus(Task.TaskStatus.NOT_READY);
      task.save();

      result = true;
      description = "Task input data successfully set.";

      BuildRunManager.execTask(task);

    } catch (TaskException e) {
      result = false;
      description = e.getMessage();
    }

    return GSON.getInstance().toJson(new BuildRunInfoResponse(result, description));
  }

}


/**
 * Contains response information
 */

class BuildRunInfoResponse {
  private Boolean result;
  private String description;

  public BuildRunInfoResponse(Boolean result, String description) {
    this.result = result;
    this.description = description;
  }

}
