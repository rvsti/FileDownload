import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import constants.AppConstants;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import svc.Downloader;
import svc.impl.HttpDownloader;
import utils.FileUtils;

public class AppTest {

  private ClassLoader classLoader;
  private HttpDownloader app = new HttpDownloader();

  @Before
  public void setup() throws IOException {
    System.out.println("------Test for App------");
    classLoader = getClass().getClassLoader();
  }

  @Test
  public void downloadFile() throws Exception {
    String urlStr = AppConstants.Http_Url;
    String path = System.getProperty("user.home") + "/" + FileUtils.getFileName(urlStr);
    app.downloadFile(urlStr,path);
    URL url = new URL(urlStr);
    URLConnection uc = url.openConnection();
    assertTrue(uc.getContentType().contains("xml"));
  }

}
