package factory;

import svc.impl.ScpDownloader;
import enums.UrlType;
import svc.Downloader;
import svc.impl.FtpDownloader;
import svc.impl.HttpDownloader;
import svc.impl.SftpDownloader;

public class DownloaderFactory {

  public Downloader getDownloader(String url) {
    if (url == null) {
      return null;
    }
    if (url.startsWith(UrlType.HTTP.getType()) || url.startsWith(UrlType.HTTPS.getType())) {
      return new HttpDownloader();
    } else if (url.startsWith(UrlType.FTP.getType())) {
      return new FtpDownloader();
    } else if(url.startsWith((UrlType.SFTP.getType()))) {
      return new SftpDownloader();
    } else if(url.startsWith(UrlType.SCP.getType())) {
      return new ScpDownloader();
    }
    return null;
  }

  }
