package javase05.t02;

import java.util.Properties;

public class Run {
    public static void main(String[] args) {
        String filename = "javase05/t02/resources/question";
        String property = "question1";
        ReadPropertiesFile.viewProperty(filename,property);

        filename = "javase05.t02/resources.ABRA-CADABRA";
        property = "question1";
        ReadPropertiesFile.viewProperty(filename,property);

        filename = "javase05.t02.resources/question";
        property = "ABRA-CADABRA";
        ReadPropertiesFile.viewProperty(filename,property);

        Properties properties = ReadPropertiesFile.getProperties(filename);
        properties.list(System.out);
    }
}
