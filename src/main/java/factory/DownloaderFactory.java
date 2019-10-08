package factory;

import com.rvsti.filedownload.svc.impl.ScpDownloader;
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
    if (url.contains(UrlType.HTTP.getType())) {
      return new HttpDownloader();
    } else if (url.contains(UrlType.FTP.getType())) {
      return new FtpDownloader();
    } else if(url.contains((UrlType.SFTP.getType()))) {
      return new SftpDownloader();
    } else if(url.contains(UrlType.SCP.getType())) {
      return new ScpDownloader();
    }
    return null;
  }

  }
