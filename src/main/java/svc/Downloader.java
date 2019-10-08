package svc;

import java.io.IOException;

public interface Downloader {

    boolean downloadFile(String url, String localPath) throws IOException;

}
