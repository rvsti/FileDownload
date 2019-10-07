package com.rvsti.filedownload.enums;

public enum UrlType {
  HTTP("http"), FTP("ftp"), SFTP("sftp"), SCP("scp");

  private String type;

  UrlType(String type){ this.type = type; }

  public String getType() {
    return type;
  }
}
