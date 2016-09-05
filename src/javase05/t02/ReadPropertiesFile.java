package javase05.t02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadPropertiesFile {

    public static String readProperty(String resource, String property){
        try {
            ResourceBundle bundle = ResourceBundle.getBundle(resource);
            if (bundle.containsKey(property)) {
                return bundle.getString(property);
            } else {
                System.out.println("EXCEPTION!!!\n\tCould not find property '" +
                        property + "' in file '" + resource + ".properties'");
            }
        } catch (MissingResourceException e) {
            System.out.println("EXCEPTION!!!\n\tCould not find file '" + resource + ".properties'");
        }
        return null;
    }

    public static String viewProperty(String resource, String property, Properties properties){
        if (properties.containsKey(property)) {
            return properties.getProperty(property);
        } else {
            System.out.println("EXCEPTION!!!\n\tCould not find property '" +
                    property + "' in file '" + resource + ".properties'");
            return null;
        }
    }

    public static Properties getAllFuckingProperties(String resource){
        Properties properties = new Properties();
        try {
            ResourceBundle bundle = ResourceBundle.getBundle(resource);
            for (String property: bundle.keySet()){
                properties.put(property,bundle.getString(property));
            }
            return properties;
        } catch (MissingResourceException e) {
            System.out.println("EXCEPTION!!!\n\tCould not find file '" + resource + ".properties'");
        }
        return null;
    }

    public static Properties getProperties(String resource){
        Properties properties = new Properties();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")
                +"/src/"+resource+".properties"))){
            properties.load(br);
        } catch (MissingResourceException e) {
            System.out.println("EXCEPTION!!!\n\tCould not find file '" + resource + ".properties'");
        } catch ( IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
