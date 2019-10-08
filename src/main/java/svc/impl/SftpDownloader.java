package svc.impl;

import constants.AppConstants;
import svc.Downloader;
import java.io.IOException;
import org.apache.commons.vfs2.*;

public class SftpDownloader implements Downloader {

  @Override
  public void downloadFile(String url,String localPath){
    try {
      FileSystemManager manager = VFS.getManager();

      FileObject local = manager.resolveFile(localPath);
      FileObject remote = manager.resolveFile(
        "sftp://" + AppConstants.Sftp_Host + ":" + AppConstants.Sftp_Username + "@"
          + AppConstants.Sftp_Password + "/" + AppConstants.Sftp_File);

      local.copyFrom(remote, Selectors.SELECT_SELF);

      local.close();
      remote.close();
    }
    catch (Exception ex) {
    }
  }
}
