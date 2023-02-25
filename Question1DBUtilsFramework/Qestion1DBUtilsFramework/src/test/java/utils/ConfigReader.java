package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties pro;

    static {
        String path ="config.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            pro = new Properties();
            pro.load(fileInputStream);
            fileInputStream.close();
        }catch (IOException e){
            System.out.println("Path " + path + "  not fount " );
        }
    }
    public static  String getProperty(String key){
        return pro.getProperty(key);
    }
}
