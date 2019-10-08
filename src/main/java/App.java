import factory.DownloaderFactory;
import svc.Downloader;
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
      urls = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return urls;
  }

  public static void main(String[] args) {
    List<String> urls = getUrls("../resources/Urls.text");
    String localPath = ("user.dir") + "/";

    for (String url : urls) {
      DownloaderFactory factory = new DownloaderFactory();
      Downloader df = factory.getDownloader(url);
      try {
        df.downloadFile(url,localPath);
      }
      catch (IOException ex)
      {

      }
    }

  }
}
