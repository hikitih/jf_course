package javase05.t02;

import java.util.Properties;

public class Run {
    public static void main(String[] args) {
        String filename = "javase05.t02/resources.ABRA-CADABRA";
        Properties properties = ReadPropertiesFile.getAllFuckingProperties(filename);
        filename = "javase05/t02/resources/question";
        properties = ReadPropertiesFile.getAllFuckingProperties(filename);

        String property = "ABRA-CADABRA";
        ReadPropertiesFile.viewProperty(filename,property,properties);
        property = "question1";
        System.out.println(ReadPropertiesFile.viewProperty(filename,property,properties));

        Properties propertiesAsMap = ReadPropertiesFile.getProperties("javase05/t02/resources/question");
        propertiesAsMap.list(System.out);
    }
}
