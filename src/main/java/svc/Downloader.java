package svc;

import java.io.IOException;

public interface Downloader {

    void downloadFile(String url, String localPath) throws IOException;

}
