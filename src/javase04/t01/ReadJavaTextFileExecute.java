package javase04.t01;

public class ReadJavaTextFileExecute {

	public static void main(String[] args){
		ReadJavaFile rjf = new ReadJavaFile();
		if (rjf.readTextFile("ReadJavaFile.java")){
			rjf.countReservedWords();
			rjf.writeTextFile("resultText.txt");
		}
	}

}