import factory.DownloaderFactory;
import svc.Downloader;
import utils.FileUtils;

import java.io.IOException;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class App {

  public static List<String> getUrls(String fileName)
  {
    List<String> urls = Collections.emptyList();
    try
    {
//      Path pathToFile = Paths.get(fileName);
//      System.out.println(pathToFile.toAbsolutePath());
      urls = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return urls;
  }

  public static void main(String[] args) {
    List<String> urls = getUrls("resources/Urls.txt");
    String localPath = System.getProperty("user.home") + "/";

    for (String url : urls) {
      DownloaderFactory factory = new DownloaderFactory();
      Downloader df = factory.getDownloader(url);
      try {
        df.downloadFile(url,localPath + FileUtils.getFileName(url));
      }
      catch (IOException ex)
      {

      }
    }

  }
}
