package zip_service;

import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.FileWriter;
import java.io.IOException;

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
  protected final Gson GSON = new Gson();

  private void setTaskInfo(FileWriter out, String info) throws IOException {
    if(info == null || info.equals("")){
      out.write("-");
    } else {
      out.write(info);
    }
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public String setBuildRunInfo(@FormParam("zipID") String zipID,
                                @FormParam("languageType") String languageType,
                                @FormParam("operation") String operation,
                                @FormParam("compileParameters") String compileParameters,
                                @FormParam("inputData") String inputData,
                                @FormParam("entryPointPath") String entryPointPath,
                                @FormParam("compilator") String compilator){

    Boolean result;
    String description;

    FileWriter taskInfoFile = null;
    FileWriter taskStatusFile = null;
    try {
      taskInfoFile = new FileWriter("D:\\DataBase\\" + zipID + "\\task info");
      setTaskInfo(taskInfoFile, languageType);
      setTaskInfo(taskInfoFile, operation);
      setTaskInfo(taskInfoFile, compileParameters);
      setTaskInfo(taskInfoFile, inputData);
      setTaskInfo(taskInfoFile, entryPointPath);
      setTaskInfo(taskInfoFile, compilator);

      taskInfoFile.close();

      taskStatusFile = new FileWriter("D:\\DataBase\\" + zipID + "\\task status");
      taskStatusFile.write("task set");
      taskStatusFile.close();

      result = true;
      description = "Task ID=" + zipID + " successfully set.";

    } catch (IOException e) {
      result = false;
      description = "Task ID=" + zipID + " saving failed.";
    }

    return GSON.toJson(new BuildRunInfoResponse(result, description));
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
