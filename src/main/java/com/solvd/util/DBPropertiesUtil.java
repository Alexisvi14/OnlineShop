package com.solvd.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DBPropertiesUtil {
    private final static Logger LOG = LogManager.getLogger(DBPropertiesUtil.class);

    private static Properties properties = new Properties();
    private static DBPropertiesUtil dbPropertiesUtil = new DBPropertiesUtil();


    private DBPropertiesUtil() {
        try {
            properties.load(new FileReader("src/main/resources/db.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
    }

    public static String getString(String key) {
        return properties.getProperty(key);
    }


    public static int getInt(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }

}
