package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

    public static String readProperty(String key) {
        String value = "";
        try(InputStream input = new FileInputStream("./src/test/java/data/config.properties")){
            Properties properties = new Properties();
            properties.load(input);
            value = properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
