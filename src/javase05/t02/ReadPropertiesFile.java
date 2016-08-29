package javase05.t02;

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

    public static void viewProperty(String resource, String property){
        String result = ReadPropertiesFile.readProperty(resource,property);
        if (result!=null){
            System.out.println(result);
        }
    }

    public static Properties getProperties(String resource){
        Properties properties = new Properties();
        try {
            ResourceBundle bundle = ResourceBundle.getBundle(resource);
            Enumeration<String> keys = bundle.getKeys();
            while (keys.hasMoreElements()) {
                String next = keys.nextElement();
                if (bundle.containsKey(next)) {
                    properties.put(next, bundle.getString(next));
                }
            }
        } catch (MissingResourceException e) {
            System.out.println("EXCEPTION!!!\n\tCould not find file '" + resource + ".properties'");
        }
        return properties;
    }
}
