package javase03.t03;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Goba on 31.07.2016.
 */
public class ReadHTML {
    public static final Charset WIN = Charset.forName("Cp1251");

    StringBuilder storage= new StringBuilder();
    ArrayList<Integer> imgNumbers = new ArrayList<>();

    public boolean readLogFromFile(String filename){
        try {
            InputStreamReader is = new InputStreamReader(new FileInputStream(System.getProperty("user.dir")
                    +"/src/javase03/t03/"+filename),WIN);

            try {
                while(is.ready()){
                    char[] cbuf = new char[1000];
                    is.read(cbuf);
                    storage.append(cbuf);
                }
            } catch (IOException e){
                System.out.println("End of file =)");
            }
            return true;
        } catch (FileNotFoundException e){
            System.out.println(e);
            return false;
        }
    }

    public boolean getNumbers(){
        //{0x0420,0x0438,0x0441};
        char c1 = 0x0420;//Р
        char c2 = 0x0438;//и
        char c3 = 0x0441;//с
        char c4 = 0x0440;//р
        Pattern pattern = Pattern.compile("(Рис\\.\\s\\d+)|(рис\\.\\s\\d+)|(Рисунок\\.\\s\\d+)|(рисунок\\.\\s\\d+)");
        Matcher matcher = pattern.matcher(storage);

        Pattern patternNumber = Pattern.compile("\\d+");
        Matcher matcherNumber;
        String s;

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            s = storage.substring(start,end);
            matcherNumber = patternNumber.matcher(s);
            if (matcherNumber.find()){
                s = s.substring(matcherNumber.start(),matcherNumber.end());
                imgNumbers.add(Integer.parseInt(s));
            }
        }

        if (imgNumbers.isEmpty()) return false;
        else return true;
    }

    public boolean areNumbersConsecutive(){
        int last = Integer.MIN_VALUE;
        for(int i: imgNumbers){
            if (i<last){return false;}
            else {
                last = i;
            }
        }
        return true;
    }

    public void getSentences(){
        Pattern patternSentence = Pattern.compile("([А-Я](.+?)[^с][.?!])");
        Matcher matcherSentence = patternSentence.matcher(storage);

        Pattern pattern = Pattern.compile("(Рис\\.\\s\\d+)|(рис\\.\\s\\d+)|(Рисунок\\s\\d+)|(рисунок\\s\\d+)");
        Matcher matcher;
        String s;
        int k = 0;

        while (matcherSentence.find()){
            int start = matcherSentence.start();
            int end = matcherSentence.end();
            s = storage.substring(start,end);
            matcher = pattern.matcher(s);
            if (matcher.find()) {
                System.out.printf("%3d",k);
                System.out.println(" ||| "+s.substring(matcher.start(),matcher.end())+" ||| "+s);
                k++;
            }
        }
        System.out.println("Sentences with pattern: "+k);
        System.out.println("Patterns: "+imgNumbers.size());
    }
}
