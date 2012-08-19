import Managers.BuildRunManager;
import zip_service.IDGenerator;
import zip_service.IllegalIDFileFormatException;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Алина
 * Date: 14.08.12
 * Time: 10:28
 */
public class Main {
  public static void main(String[] args) {
    try {
      BuildRunManager.build(BuildRunManager.BUILD);
      System.out.println("Ok!");
    } catch (IOException e) {
      System.err.println("IOException! " + e.toString());
    } catch (InterruptedException e){
      System.err.println("InterruptedException!");
    }

//    try {
//      String id1 = IDGenerator.getNextID();
//      String id2 = IDGenerator.getNextID();
//      String id3 = IDGenerator.getNextID();
//      String id4 = IDGenerator.getNextID();
//    } catch (IllegalIDFileFormatException e) {
//
//    }

  }
}
