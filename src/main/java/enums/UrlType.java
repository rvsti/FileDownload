package enums;

public enum UrlType {
  HTTP("http"), HTTPS("HTTPS"), FTP("ftp"), SFTP("sftp"), SCP("scp");

  private String type;

  UrlType(String type){ this.type = type; }

  public String getType() {
    return type;
  }
}
