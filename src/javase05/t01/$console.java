package javase05.t01;

//import java.util.ArrayList;
import java.lang.Object;
import java.io.*;

public class $console {
	public static void main(String[] args){
		FileSystem fs = new FileSystem();
		fs.printAllFilesFrom("./src/javase05/");
		fs.createTextFile("/src/javase05/t01/test.txt");
		fs.createTextFile("/src/javase05/t01/test.txt");
		fs.deleteTextFile("/src/javase05/t01/test.txt");
		fs.deleteTextFile("/src/javase05/t01/test.txt");
		fs.addStringToTextFile("/src/javase05/t01/test.txt","Nobody will see it");

		fs.createTextFile("/src/javase05/t01/test.txt");
		fs.addStringToTextFile("/src/javase05/t01/test.txt","First string");
		fs.addStringToTextFile("/src/javase05/t01/test.txt","Second string");
		fs.addStringToTextFile("/src/javase05/t01/test.txt","Third string");

		for (String s:fs.getAllFilesToStringArray("./src/javase05/")){
			fs.addStringToTextFile("/src/javase05/t01/test.txt",s);
		}
	}	
}