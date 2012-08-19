package zip_service;

import com.google.gson.Gson;

import javax.ws.rs.*;
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
public class GetBuildLogsHandler {
  protected final Gson GSON = new Gson();

  @GET
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public String getBuildLogs(@QueryParam("zipID") String zipID) {

    Boolean result = true;
    String description = "";
    String buildLogs = "";

    return GSON.toJson(new BuildLogsResponse(result, description, buildLogs));
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