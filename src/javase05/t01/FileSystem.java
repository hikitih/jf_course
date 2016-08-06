package javase05.t01;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.lang.Object;
import java.io.*;
import java.util.Properties;

public class FileSystem{
	ArrayList<File> allFiles = new ArrayList<File>();
	public static final Charset WIN = Charset.forName("Cp1251");
	public static final Charset UTF8 = Charset.forName("UTF-8");
	public static final Charset UTF16 = Charset.forName("UTF-16");
	public static final Charset UTF16BE = Charset.forName("UTF-16BE");
	public static final Charset UTF16LE = Charset.forName("UTF-16LE");
	public static final Charset EN = Charset.forName("ISO-8859-1");
	public static final Charset US = Charset.forName("US-ASCII");
	public static final Charset DEF = Charset.forName(System.getProperty("file.encoding"));


	public void addFileToList(File file){
		if (file.isDirectory()) {
			allFiles.add(file);
			File[] subfiles = file.listFiles();
			for (File subfile: subfiles){addFileToList(subfile);}
		} else {
			allFiles.add(file);
		}
	}

	public void getAllFiles(){
		File root = new File(System.getProperty("user.dir"));
		while (root.getParentFile()!=null){root = root.getParentFile();}
		File[] files = root.listFiles();
		for (File file: files){
			addFileToList(file);
		}
	}

	public void getAllFilesFrom(String path){
		allFiles.clear();
		File root = new File(path);
		File[] files = root.listFiles();
		for (File file: files){
			addFileToList(file);
		}
	}

	public String[] getAllFilesToStringArray(String path){
		String[] s = new String[allFiles.size()];
		int counter = 0;
		for (File file: allFiles) {
			s[counter] = file.toString();
			counter++;
		}
		return s;
	}

	public void addStringToTextFile(String filename,String string){
		addStringToTextFile(System.getProperty("user.dir"),filename,string);
	}

	public void addStringToTextFile(String path,String filename,String string){
		File file = new File(path+filename);
		if (!file.exists()) {
			System.out.println("ERROR: File does not exists");
			return;
		}
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(
			new FileWriter(file,true)))){
			pw.println(string);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			System.out.println("ERROR: Could not open file");
		}
	}

	public void createTextFile(String filename){
		createTextFile(System.getProperty("user.dir"),filename);
	}

	public void createTextFile(String path,String filename){
		File file = new File(path+filename);
		try {
			if (!file.createNewFile()) {
				System.out.println("ERROR: File already exists");
			}
		} catch (IOException e){
			System.out.println("ERROR: Could not create file");
		}
	}

	public void deleteTextFile(String filename){
		deleteTextFile(System.getProperty("user.dir"),filename);
	}

	public void deleteTextFile(String path,String filename){
		File file = new File(path+filename);
		if (!file.delete()) {
			System.out.println("ERROR: File not found. Could not delete the file");
		}
	}

	public void printAllFilesFrom(String path){
		getAllFilesFrom(path);
		for (File file: allFiles){
			System.out.println(file.toString());
		}
	}
}