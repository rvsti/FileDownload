package svc.impl;

import constants.AppConstants;
import svc.Downloader;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class HttpDownloader implements Downloader {

  @Override
  public void downloadFile(String urlStr) throws IOException {
    URL url = new URL(urlStr);
    String file = AppConstants.Http_Filepath;
    BufferedInputStream bis = new BufferedInputStream(url.openStream());
    FileOutputStream fis = new FileOutputStream(file);
    byte[] buffer = new byte[1024];
    int count=0;
    while((count = bis.read(buffer,0,1024)) != -1)
    {
      fis.write(buffer, 0, count);
    }
    fis.close();
    bis.close();

  }
}
