package zip_service;

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
 * Time: 17:59
 * Handling all requests on "rest/getBuildZip" URL: rest/getBuildZip
 * Method: GET Required response: zip file
 */

@Path("/getBuildZip")
public class GetBuildZipHandler {
  @GET
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public InputStream getBuildLogs(@QueryParam("getBuildZip") Integer zipFileID) {
    InputStream buildZip = null;
    try {
      buildZip = new FileInputStream(new File("d://data//tmp.txt"));
    } catch (FileNotFoundException e) {

    }
    return buildZip;
  }
}
