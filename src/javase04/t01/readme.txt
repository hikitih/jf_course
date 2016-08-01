First and second tasks from fourth homework.

ReadJavaFile.class contains all methods
ReadJavaFileExecute.class put the result from "ReadJavaFile.java" to "result.txt"
ReadJavaTextFileExecute.class put the result from "ReadJavaFile.java" to "resultText.txt"
TransferTextFromUtf8ToUtf16.class takes UTF-8 text from "Text for test.txt" and put the same UTF-16 text to "Test results.txt"

to change analyzed file go into ReadJavaFileExecute.class, ReadJavaTextFileExecute.class or TransferTextFromUtf8ToUtf16.class respectively.

Although I made pretty scary procedure to get path to files it works when I compile my programs from cmd with 

javac -cp ./src -d ./src src/javase04/t01/ReadJavaFile.java

command. And similar commands to other compilations. And run with

java -cp ./src javase04.t01.TransferTextFromUtf8ToUtf16

and similar commands also works fine =)
