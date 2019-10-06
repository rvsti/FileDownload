package com.rvsti.filedownload.enums;

public enum UrlType {
  HTTP("HTTP"), FTP("FTP");

  private String type;

  UrlType(String type){ this.type = type; }

  public String getType() {
    return type;
  }
}
