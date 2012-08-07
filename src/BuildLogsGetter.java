import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
 */

@Path("/getBuildLogs")
public class BuildLogsGetter {
  @GET
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public InputStream getBuildLogs(@FormParam("getBuildLogs") Integer zipFileID) {
    InputStream buildLogs = null;
    try {
      buildLogs = new FileInputStream(new File("d://data//tmp.txt"));
    } catch (FileNotFoundException e) {

    }
    return buildLogs;
  }
}
