package javase04.t01;

public class TransferTextFromUtf8ToUtf16 {

	public static void main(String[] args){
		ReadJavaFile rf = new ReadJavaFile();
		if (rf.readFile("Text for test.txt",rf.UTF8)){
			rf.writeWholeFile("Test results.txt",rf.UTF16);
		}
	}

}