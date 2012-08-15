import zip_service.IDGenerator;
import zip_service.IllegalIDFileFormatException;
import zip_service.ZipHandler;

import java.util.zip.ZipFile;

/**
 * Created with IntelliJ IDEA.
 * User: Алина
 * Date: 14.08.12
 * Time: 10:28
 */
public class Main {
  public static void main(String[] args) {
    //ZipHandler.zipFile("D:\\test.zip");

    try {
      String id1 = IDGenerator.getNextID();
      String id2 = IDGenerator.getNextID();
      String id3 = IDGenerator.getNextID();
      String id4 = IDGenerator.getNextID();
    } catch (IllegalIDFileFormatException e) {

    }

  }
}
