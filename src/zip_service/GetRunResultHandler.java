package zip_service;

import com.google.gson.Gson;

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
    Boolean requestResult = true;
    String resultDescription = "";
    String runResult = "";

    return GSON.toJson(new BuildLogsResponse(requestResult, resultDescription, runResult));
  }
}


/**
 * Contains response information
 */

class RunResultResponse {
  private Boolean requestResult;
  private String resultDescription;
  private String runResult;

  public RunResultResponse(Boolean requestResult, String resultDescription, String runResult) {
    this.requestResult = requestResult;
    this.resultDescription = resultDescription;
    this.runResult = runResult;
  }
}
