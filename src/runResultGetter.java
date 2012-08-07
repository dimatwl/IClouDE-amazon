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
 * Time: 17:34
 */

@Path("/getRunResult")
public class runResultGetter {
  @GET
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public InputStream getBuildLogs(@FormParam("getRunResult") Integer zipFileID) {
    InputStream runResult = null;
    try {
      runResult = new FileInputStream(new File("d://data//tmp.txt"));
    } catch (FileNotFoundException e) {

    }
    return runResult;
  }
}
