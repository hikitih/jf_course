package javase04.t01;

import java.nio.charset.Charset;
import java.io.*;
import java.util.regex.*;

public class ReadJavaFile {
	public static final Charset WIN = Charset.forName("Cp1251");
	public static final Charset UTF8 = Charset.forName("UTF8");
	public static final Charset UTF16 = Charset.forName("UTF16");
	StringBuilder storage = new StringBuilder();
	String[] reservedWords = new String[53];
	int[] reservedWordsCount;

	public ReadJavaFile(){
		fillReservedWords();
		reservedWordsCount = new int[reservedWords.length];
		for (int i=0; i<reservedWords.length; i++){
			reservedWordsCount[i] = 0;
		}
	}

	public boolean readTextFile(String filename){
		try{
			BufferedReader br = new BufferedReader(
				new FileReader(System.getProperty("user.dir")
				+"/src/javase04/t01/"+filename));
			try{
				while(br.ready()){
					storage.append(br.readLine());
				}
			} catch (IOException e){
				System.out.println(e);
			}
			return true;
		} catch (FileNotFoundException e){
			System.out.println(e);
			return false;
		}
	}

	public boolean readFile(String filename){
		return readFile(filename, WIN);
	}

	public boolean readFile(String filename, Charset cs){
		try{
			InputStreamReader is = new InputStreamReader(
				new FileInputStream(System.getProperty("user.dir")
				+"/src/javase04/t01/"+filename),cs);
			try{
				while(is.ready()){
					char[] cbuf = new char[1000];
					is.read(cbuf);
					storage.append(cbuf);
				}
			} catch (IOException e){
				System.out.println(e);
			}
			return true;
		} catch (FileNotFoundException e){
			System.out.println(e);
			return false;
		}
	}

	public boolean writeTextFile(String filename){
		String lineSeparator = System.getProperty("line.separator");
		try{
			BufferedWriter br = new BufferedWriter(
				new FileWriter(System.getProperty("user.dir")
				+"/src/javase04/t01/"+filename));
			try{
				for (int i=0; i<reservedWords.length; i++){
					br.write(reservedWords[i]+" : "+reservedWordsCount[i]+lineSeparator);
				}
				br.flush();
			} catch (IOException e){
				System.out.println(e);
			}
			return true;
		} catch (FileNotFoundException e){
			System.out.println(e);
			return false;
		} catch (IOException e)	{
			System.out.println(e);
			return false;
		}
	}

	public boolean writeWholeFile(String filename, Charset cs){
		String lineSeparator = System.getProperty("line.separator");
		try{
			OutputStreamWriter os = new OutputStreamWriter(
				new FileOutputStream(System.getProperty("user.dir")
				+"/src/javase04/t01/"+filename),cs);
			try{
				os.write(storage.toString());
				os.flush();
			} catch (IOException e){
				System.out.println(e);
			}
			return true;
		} catch (FileNotFoundException e){
			System.out.println(e);
			return false;
		}		
	}

	public boolean writeFile(String filename){
		return writeFile(filename, WIN);
	}

	public boolean writeFile(String filename, Charset cs){
		String lineSeparator = System.getProperty("line.separator");
		try{
			OutputStreamWriter os = new OutputStreamWriter(
				new FileOutputStream(System.getProperty("user.dir")
				+"/src/javase04/t01/"+filename),cs);
			try{
				for (int i=0; i<reservedWords.length; i++){
					os.write(reservedWords[i]+" : "+reservedWordsCount[i]+lineSeparator);
				}
				os.flush();
			} catch (IOException e){
				System.out.println(e);
			}
			return true;
		} catch (FileNotFoundException e){
			System.out.println(e);
			return false;
		}		
	}

	public void countReservedWords(){
		String s="";
		for (int i=reservedWords.length-1; i>0; i--){
			s = s+"("+reservedWords[i]+")++|";
		}
		s = s+"("+reservedWords[0]+")++";
		Pattern pattern = Pattern.compile(s);
		Matcher matcher = pattern.matcher(storage);

		while(matcher.find()){
			int start = matcher.start();
			int end = matcher.end();
			s = storage.substring(start,end);
			for (int i=0; i<reservedWords.length; i++){
				if (s.equals(reservedWords[i])){
					reservedWordsCount[i]++;
					break;
				}
			}
		}
	}

	private void fillReservedWords(){
		reservedWords[0]="abstract";
		reservedWords[1]="assert";
		reservedWords[2]="boolean";
		reservedWords[3]="break";
		reservedWords[4]="byte";
		reservedWords[5]="case";
		reservedWords[6]="catch";
		reservedWords[7]="char";
		reservedWords[8]="class";
		reservedWords[9]="const";

		reservedWords[10]="continue";
		reservedWords[11]="default";
		reservedWords[12]="do";
		reservedWords[13]="double";
		reservedWords[14]="else";
		reservedWords[15]="enum";
		reservedWords[16]="extends";
		reservedWords[17]="final";
		reservedWords[18]="finally";
		reservedWords[19]="float";

		reservedWords[20]="for";
		reservedWords[21]="goto";
		reservedWords[22]="if";
		reservedWords[23]="implements";
		reservedWords[24]="import";
		reservedWords[25]="instanceof";
		reservedWords[26]="int";
		reservedWords[27]="interface";
		reservedWords[28]="long";
		reservedWords[29]="native";

		reservedWords[30]="new";
		reservedWords[31]="package";
		reservedWords[32]="private";
		reservedWords[33]="protected";
		reservedWords[34]="public";
		reservedWords[35]="return";
		reservedWords[36]="short";
		reservedWords[37]="static";
		reservedWords[38]="strictfp";
		reservedWords[39]="super";

		reservedWords[40]="switch";
		reservedWords[41]="synchronized";
		reservedWords[42]="this";
		reservedWords[43]="throw";
		reservedWords[44]="throws";
		reservedWords[45]="transient";
		reservedWords[46]="try";
		reservedWords[47]="void";
		reservedWords[48]="volatile";
		reservedWords[49]="while";

		reservedWords[50]="null";
		reservedWords[51]="true";
		reservedWords[52]="false";
	}	

}