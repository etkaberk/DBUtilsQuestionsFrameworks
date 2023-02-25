package utils;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
private static Properties pro;

static {
    String path = "config.properties";
    try {
        FileInputStream fis = new FileInputStream(path);
        pro = new Properties();
        pro.load(fis);
        fis.close();
    }catch (Exception e){
        throw new RuntimeException(e);
    }
}

public static String getProperty(String key ){
    return pro.getProperty(key);
}
}
