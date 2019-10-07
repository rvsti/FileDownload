package com.rvsti.filedownload.svc;

import java.io.IOException;

public interface Downloader {

  void downloadFile(String url) throws IOException;

}
