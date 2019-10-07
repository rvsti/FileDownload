package com.rvsti.filedownload.svc.impl;

import com.rvsti.filedownload.svc.Downloader;
import java.io.IOException;
import org.apache.commons.vfs2.*;

public class SftpDownloader implements Downloader {
  String user, pwd, remoteHost, remoteFile;
  public SftpDownloader(String user, String pwd, String remoteHost, String remoteFile)
  {
    this.user = user;
    this.pwd = pwd;
    this.remoteHost = remoteHost;
    this.remoteFile = remoteFile;
  }

  @Override
  public void downloadFile(String url) throws IOException {
    FileSystemManager manager = VFS.getManager();

    FileObject local = manager.resolveFile(
      System.getProperty("user.dir") + "/"  + "vfsFile.txt");
    FileObject remote = manager.resolveFile(
      "sftp://" + user + ":" + pwd + "@" + remoteHost + "/" + remoteFile);

    local.copyFrom(remote, Selectors.SELECT_SELF);

    local.close();
    remote.close();
  }
}
