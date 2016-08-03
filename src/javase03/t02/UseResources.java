package javase03.t02;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.nio.charset.Charset;

public class UseResources {
    public static final Charset OLD = Charset.forName("ISO-8859-1");
    public static final Charset NEW = Charset.defaultCharset();

    public static void main(String[] args){
        ResourceBundle bundle;
        Locale locale_rus = new Locale("rus","RU");
        Locale locale_eng = new Locale("eng","EN");
        Locale locale;

        System.out.println("Choose language/Выберите язык: ");
        System.out.println("1 - English/Английский");
        System.out.println("2 - Russian/Русский");
        char c = 0;
        while (!((c=='1')||(c=='2'))) {
            try {
                c = (char) System.in.read();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        switch (c){
            case '1':   locale = locale_eng;
                        System.out.println("Choose question: ");
                break;
            case '2':   locale = locale_rus;
                        System.out.println("Выберите вопрос: ");
                break;
            default:    locale = locale_eng;
        }

        bundle = ResourceBundle.getBundle("javase03.t02.resources.question",locale);

        int counter = 1;
        String question = "question"+counter;
        while (bundle.containsKey(question)) {
            String s = bundle.getString(question);
            String s2 = new String(s.getBytes(OLD),NEW);
            System.out.println(counter+" - "+s2);
            counter++;
            question = "question"+counter;
        }
        byte b = 0;
        while ((b<49)||(b>49+counter-2)) {
            try {
                c = (char) System.in.read();
                b = (byte) c;
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        c = (char) b;
        String answer = "answer"+c;
        bundle = ResourceBundle.getBundle("javase03.t02.resources.answer",locale);
        if (bundle.containsKey(answer)) {
            String s = bundle.getString(answer);
            String s2 = new String(s.getBytes(OLD),NEW);
            System.out.println(s2);
        } else {
            System.out.println("Лошара!");
        }

    }
}
