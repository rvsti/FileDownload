package svc.impl;

import constants.AppConstants;
import svc.Downloader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FtpDownloader implements Downloader {

  FTPClient ftp = null;

  public void initializeClient(String url) {
    ftp = new FTPClient();
    ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
    int reply;
    try {
      String host = url.substring(6);
      ftp.connect(host);
      System.out.println(host);
      reply = ftp.getReplyCode();
      if (!FTPReply.isPositiveCompletion(reply)) {
        ftp.disconnect();
        throw new Exception("Exception in connecting to FTP Server");
      }
      ftp.login(AppConstants.Ftp_Username, AppConstants.Ftp_Password);
      ftp.setFileType(FTP.BINARY_FILE_TYPE);
      ftp.enterLocalPassiveMode();
    }
    catch (Exception ex){

    }
  }

  @Override
  public boolean downloadFile(String url, String localPath) {
    initializeClient(url);
    try (FileOutputStream fos = new FileOutputStream(localPath)) {
      this.ftp.retrieveFile(localPath, fos);
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
    if (this.ftp.isConnected()) {
      try {
        this.ftp.logout();
        this.ftp.disconnect();
        return true;
      } catch (IOException f) {
        System.out.println(f);
        return false;

      }
    }
    return false;
  }
}
