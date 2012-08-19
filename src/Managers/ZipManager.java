package Managers;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Алина
 * Date: 14.08.12
 * Time: 9:22
 * Zip & unzip file by path name
 */
public class ZipManager {

  private static final void copyInputStream(InputStream in, OutputStream out)
          throws IOException {
    byte[] buffer = new byte[1024];
    int len;
    while ((len = in.read(buffer)) >= 0) {
      out.write(buffer, 0, len);
    }
    in.close();
    out.close();
  }

  public static void unzipFile(String zipFileName) {
    Enumeration entries;
    ZipFile zipFile;

    try {
      zipFile = new ZipFile(zipFileName);
      entries = zipFile.entries();
      String dirName = new String(zipFileName.getBytes(), 0, zipFileName.length() - 4);
      (new File(dirName)).mkdir();

      while (entries.hasMoreElements()) {
        ZipEntry entry = (ZipEntry) entries.nextElement();
        if (entry.isDirectory()) {
          // Assume directories are stored parents first then children.
          System.err.println("Extracting directory: " + entry.getName());
          // This is not robust, just for demonstration purposes.
          (new File(dirName + "\\" + entry.getName())).mkdir();
          continue;
        }
        System.err.println("Extracting file: " + entry.getName());
        copyInputStream(zipFile.getInputStream(entry),
                new BufferedOutputStream(new FileOutputStream(dirName + "\\" + entry.getName())));
      }
      zipFile.close();
    } catch (IOException ioe) {
      System.err.println("Unhandled exception!");
      return;
    }
  }

  public static void zipFile(String folderName) {

    // Create a buffer for reading the files
    byte[] buf = new byte[1024];

    try {
      // Create the ZIP file
      String outZipFileName = folderName;
      ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outZipFileName));

      // Compress the files
      FileInputStream in = new FileInputStream(folderName);

      // Add ZIP entry to output stream.
      out.putNextEntry(new ZipEntry(folderName));

      // Transfer bytes from the file to the ZIP file
      int len;
      while ((len = in.read(buf)) > 0) {
        out.write(buf, 0, len);
      }

      // Complete the entry
      out.closeEntry();
      in.close();

      // Complete the ZIP file
      out.close();
    } catch (IOException e) {
    }
  }

}
