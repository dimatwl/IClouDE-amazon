package zip_service;

import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Алина
 * Date: 07.08.12
 * Time: 17:34
 * Handling all requests on "rest/getRunResult" URL: rest/getRunResult
 * Method: GET Required response: RunResult
 */

@Path("/getRunResult")
public class GetRunResultHandler {
  protected final Gson GSON = new Gson();

  @GET
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public String getBuildLogs(@QueryParam("zipID") String zipID) {
    Boolean result = false;
    String description = "Get build logs failed.";
    String runResult = "";

    BufferedReader taskStatusFile = null;
    BufferedReader runResultFile = null;
    String taskStatus;
    try {
      taskStatusFile = new BufferedReader(new FileReader("D:\\DataBase\\" + zipID + "\\task status"));
      taskStatus = taskStatusFile.readLine();

      if (taskStatus != null && taskStatus.equals("task ready")) {
        runResultFile = new BufferedReader(new FileReader("D:\\DataBase\\" + zipID + "\\run"));
        String str;
        while ((str = runResultFile.readLine()) != null){
          runResult += str + '\n';
        }
        runResultFile.close();

        result = true;
        description = "Run result successfully packed.";
      }

    } catch (FileNotFoundException e) {
    } catch (IOException e) {
    }

    return GSON.toJson(new BuildLogsResponse(result, description, runResult));
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
