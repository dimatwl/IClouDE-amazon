package zip_service;

import com.google.gson.Gson;

import javax.ws.rs.*;
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
  protected final Gson GSON = new Gson();

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public String setBuildRunInfo(@FormParam("zipID") String zipID,
                                @FormParam("languageType") String languageType,
                                @FormParam("operation") String operation,
                                @FormParam("compileParameters") String compileParameters,
                                @FormParam("inputData") String inputData,
                                @FormParam("entryPointPath") String entryPointPath,
                                @FormParam("compilator") String compilator){

    Boolean requestResult = true;
    String resultDescription = "";
    return GSON.toJson(new BuildRunInfoResponse(requestResult, resultDescription));
  }

}


/**
 * Contains response information
 */

class BuildRunInfoResponse {
  private Boolean requestResult;
  private String resultDescription;

  public BuildRunInfoResponse(Boolean requestResult, String resultDescription) {
    this.requestResult = requestResult;
    this.resultDescription = resultDescription;
  }

}
