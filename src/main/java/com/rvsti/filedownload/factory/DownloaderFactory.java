package com.rvsti.filedownload.factory;

import com.rvsti.filedownload.enums.UrlType;
import com.rvsti.filedownload.svc.Downloader;
import com.rvsti.filedownload.svc.impl.FtpDownloader;
import com.rvsti.filedownload.svc.impl.HttpDownloader;
import com.rvsti.filedownload.svc.impl.SftpDownloader;

public class DownloaderFactory {

  public Downloader getDownloader(String url) {
    if (url == null) {
      return null;
    }
    if (url.contains(UrlType.HTTP.getType())) {
      return new HttpDownloader();
    } else if (url.contains(UrlType.FTP.getType())) {
      return new FtpDownloader();
      }
    else if(url.contains((UrlType.SFTP.getType()))) {
      return new SftpDownloader();
    }
    return null;
  }

  }
