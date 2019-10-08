package com.rvsti.filedownload.factory;

import com.rvsti.filedownload.enums.UrlType;
import com.rvsti.filedownload.svc.Downloader;
import com.rvsti.filedownload.svc.impl.FtpDownloader;
import com.rvsti.filedownload.svc.impl.HttpDownloader;
import com.rvsti.filedownload.svc.impl.ScpDownloader;
import com.rvsti.filedownload.svc.impl.SftpDownloader;

public class DownloaderFactory {

  public Downloader getDownloader(String url) {
    if (url == null) {
      return null;
    }
    if (url.contains(UrlType.HTTP.getType())) {
      return new HttpDownloader();
    } else if (url.contains(UrlType.FTP.getType())) {
      return new FtpDownloader("ftp_server.journaldev.com", "ftp_user@journaldev.com", "ftpPassword");
      }
    else if(url.contains((UrlType.SFTP.getType()))) {
      return new SftpDownloader("","","","");
    } else if(url.contains(UrlType.SCP.getType())) {
      return new ScpDownloader();
    }
    return null;
  }

  }
