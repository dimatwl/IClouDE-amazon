package zip_service;

import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Алина
 * Date: 19.08.12
 * Time: 16:21
 */

@Path("/checkTaskStatus")
public class CheckTaskStatusHandler {
  protected final Gson GSON = new Gson();

  @GET
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public String getTaskStatus(@QueryParam("zipID") String zipID) {

    Boolean result;
    String description;

    BufferedReader in = null;
    String taskStatus;
    try {
      in = new BufferedReader(new FileReader("D:\\DataBase\\" + zipID + "\\task status"));
      taskStatus = in.readLine();
      in.close();

      if(taskStatus != null && taskStatus.equals("task ready")) {
        result = true;
        description = "Task is ready.";
      } else {
        result = false;
        description = "Task is not ready.";
      }

    } catch (FileNotFoundException e) {
      result = false;
      description = "Check task status failed.";

    } catch (IOException e){
      result = false;
      description = "Check task status failed.";
    }

    return GSON.toJson(new CheckTaskStatusResponse(result, description));
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
