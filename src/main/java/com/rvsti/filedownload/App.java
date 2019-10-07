package com.rvsti.filedownload;

import com.rvsti.filedownload.factory.DownloaderFactory;
import com.rvsti.filedownload.svc.Downloader;
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
    List<String> urls = getUrls("/Users/mmt7924/FileDownload/src/main/resources/Urls.text");;


    for (String url : urls) {
      DownloaderFactory factory = new DownloaderFactory();
      Downloader df = factory.getDownloader(url);
      try {
        df.downloadFile(url);
      }
      catch (IOException ex)
      {

      }
    }

  }
}
