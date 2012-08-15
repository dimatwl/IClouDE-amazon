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
 * Time: 15:55
 * Handling all requests on "rest/getBuildLogs" URL: rest/getBuildLogs
 * Method: GET Required response: BuildLogs
 */


@Path("/getBuildLogs")
public class GetBuildLogsHandler {
  protected final Gson GSON = new Gson();

  @GET
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public String getBuildLogs(@QueryParam("zipID") String zipID) {

    Boolean requestResult = true;
    String resultDescription = "";
    String buildLogs = "";

    return GSON.toJson(new BuildLogsResponse(requestResult, resultDescription, buildLogs));
  }
}


/**
 * Contains response information
 */

class BuildLogsResponse {
  private Boolean requestResult;
  private String resultDescription;
  private String buildLogs;

  public BuildLogsResponse(Boolean requestResult, String resultDescription, String buildLogs) {
    this.requestResult = requestResult;
    this.resultDescription = resultDescription;
    this.buildLogs = buildLogs;
  }
}