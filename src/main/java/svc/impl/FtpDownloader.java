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

  public FtpDownloader() {
    ftp = new FTPClient();
    ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
    int reply;
    try {
      ftp.connect(AppConstants.Ftp_Host);
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
  public void downloadFile(String url, String localPath) {
    try (FileOutputStream fos = new FileOutputStream(localPath)) {
      this.ftp.retrieveFile(AppConstants.Ftp_Filepath, fos);
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (this.ftp.isConnected()) {
      try {
        this.ftp.logout();
        this.ftp.disconnect();
      } catch (IOException f) {
      }
    }
  }
}
