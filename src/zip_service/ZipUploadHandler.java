package zip_service;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

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
  protected final Gson GSON = new Gson();

  @POST
  @Produces("text/plain")
  //@Consumes(MediaType.TEXT_PLAIN)
  //@Consumes(MediaType.MULTIPART_FORM_DATA)
  //@Produces(MediaType.TEXT_PLAIN)
  public String uploadFile(@Context HttpServletRequest request) {


    Boolean requestResult = true;
    String resultDescription = "";
    String zipID = "";

    return GSON.toJson(new BuildLogsResponse(requestResult, resultDescription, zipID));
  }

  /*@FormDataParam("zipFile") String fileName
/*@FormDataParam("zipFile") InputStream uploadedInputStream,
@FormDataParam("zipFile") FormDataContentDisposition fileDetail*/

  /*
 String uploadedFileLocation = fileDetail.getFileName();

 // save it
 //aveFile(uploadedInputStream, uploadedFileLocation);

 String output = "File uploaded to : " + uploadedFileLocation;

 Integer zipFileID = 27;
 return zipFileID;*/

  /*
  FileWriter os = new FileWriter("data.txt");
  System.out.println("Enter text:");

  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  String str = new String();
  str = in.readLine();
  str = str.replaceAll("  ", " ");
  os.write(str);
  os.close();

  // save uploaded file to new location
  private void saveFile(InputStream uploadedInputStream,
                           String uploadedFileLocation) {


    try {
      FileWriter savenZipFile = new FileWriter("c:\\data\\")

      //OutputStream out = new FileOutputStream(new File(uploadedFileLocation));

      int read = 0;
      byte[] bytes = new byte[1024];

      while ((read = uploadedInputStream.read(bytes)) != -1) {
        out.write(bytes, 0, read);
      }
      out.flush();
      out.close();
    } catch (IOException e) {

    }

    try {
      final int BUFFER = 2048;
      BufferedOutputStream dest = null;
      FileInputStream fis = new FileInputStream(uploadedFileLocation);
      CheckedInputStream checksum = new CheckedInputStream(fis, new Adler32());
      ZipInputStream zis = new ZipInputStream(new BufferedInputStream(checksum));
      ZipEntry entry;
      while((entry = zis.getNextEntry()) != null) {
        System.out.println("Extracting: " + entry);
        int count;
        byte data[] = new byte[BUFFER];
        // write the files to the disk
        FileOutputStream fos = new FileOutputStream(entry.getName());
        dest = new BufferedOutputStream(fos, BUFFER);
        while ((count = zis.read(data, 0, BUFFER)) != -1) {
          dest.write(data, 0, count);
        }
        dest.flush();
        dest.close();
      }
      zis.close();
      System.out.println("Checksum: " + checksum.getChecksum().getValue());
    } catch(Exception e) {
      e.printStackTrace();
    }

  }
  */
}

/**
 * Contains response information
 */

class ZipUploadResponse {
  private Boolean requestResult;
  private String resultDescription;
  private String zipID;

  public ZipUploadResponse(Boolean requestResult, String resultDescription, String buildLogs) {
    this.requestResult = requestResult;
    this.resultDescription = resultDescription;
    this.zipID = zipID;
  }
}
