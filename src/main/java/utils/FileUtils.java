package utils;

public class FileUtils {
    public static String getFileName(String url) {
        System.out.println(url);
        String fileName = url.substring(url.lastIndexOf('/') + 1);
        System.out.println("Filename " + fileName);
        return fileName;
    }
}
