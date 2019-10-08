package svc.impl;

import constants.AppConstants;
import svc.Downloader;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class HttpDownloader implements Downloader {

  @Override
  public boolean downloadFile(String urlStr, String localPath) {
    try {
      URL url = new URL(urlStr);
      System.out.println("Local path : " + localPath);

      BufferedInputStream bis = new BufferedInputStream(url.openStream());
      FileOutputStream fis = new FileOutputStream(localPath);
      byte[] buffer = new byte[1024];
      int count = 0;
      while ((count = bis.read(buffer, 0, 1024)) != -1) {
        fis.write(buffer, 0, count);
      }
      fis.close();
      bis.close();
      return true;
    } catch(Exception e){
      System.out.println(e);
      return false;
    }

  }
}
