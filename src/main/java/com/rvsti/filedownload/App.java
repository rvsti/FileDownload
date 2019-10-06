package com.rvsti.filedownload;

import com.rvsti.filedownload.factory.DownloaderFactory;
import com.rvsti.filedownload.svc.Downloader;
import java.util.ArrayList;
import java.util.List;

public class App {

  public static void main(String[] args) {
    List<String> urls = new ArrayList<>();
    urls.add("https://www.journaldev.com/sitemap.xml");
    urls.add("https://www.journaldev.com/sitemap.xml");

    for (String url : urls) {
      DownloaderFactory factory = new DownloaderFactory();
      Downloader d = factory.getDownloader(url);
    }

  }
}
