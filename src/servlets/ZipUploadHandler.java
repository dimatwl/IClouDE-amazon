package servlets;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import managers.GSON;
import managers.Task;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Алина
 * Date: 07.08.12
 * Time: 13:29
 * Handling all requests on "rest/uploadZip" URL: rest/uploadZip
 * Method: POST Required response: ID
 */

@Path("/uploadZip")
public class ZipUploadHandler {

  @POST
  @Consumes(MediaType.MULTIPART_FORM_DATA)

  public String uploadFile(@FormDataParam("zipFile") InputStream uploadedInputStream,
                           @FormDataParam("zipFile") FormDataContentDisposition fileDetail) {


    Boolean result;
    String description;
    String taskID;


    String fileName = fileDetail.getFileName();

    if (!fileName.substring(fileName.length() - 4, fileName.length() - 1).equals(".zip")) {
      result = false;
      description = "Zip project file has invalid format.";
      taskID = "";

    } else {
      try {
        taskID = IDGenerator.getNextID();
        Task task = new Task(taskID, fileName.substring(0, fileName.length() - 4));
        task.setTaskStatus(Task.TaskStatus.NOT_SET);
        task.setZip(uploadedInputStream, fileDetail.getFileName());
        task.save();

        result = true;
        description = "Zip file successfully uploaded.";

      } catch (IllegalIDFileFormatException e) {
        result = false;
        description = "ID generation for current task failed.";
        taskID = "";
      } catch (TaskException e) {
        result = false;
        description = e.getMessage();
        taskID = "";
      }
    }
    return GSON.getInstance().toJson(new ZipUploadResponse(result, description, taskID));
  }

}

/**
 * Contains response information
 */

class ZipUploadResponse {
  private Boolean result;
  private String description;
  private String zipID;

  public ZipUploadResponse(Boolean result, String description, String zipID) {
    this.result = result;
    this.description = description;
    this.zipID = zipID;
  }
}
