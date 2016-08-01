package javase04.t01;

public class ReadJavaFileExecute {

	public static void main(String[] args){
		ReadJavaFile rjf = new ReadJavaFile();
		if (rjf.readFile("ReadJavaFile.java")){
			rjf.countReservedWords();
			rjf.writeFile("result.txt");
		}
	}

}