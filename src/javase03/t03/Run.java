package javase03.t03;

public class Run {
    public static void main(String[] args) {
        ReadHTML rh = new ReadHTML();
        if (rh.readLogFromFile("Java.SE.03.Information handling_task_attachment.html")){
            if (rh.getNumbers()){
                if (rh.areNumbersConsecutive()){
                    System.out.println("Image numbers are consecutive");
                } else {
                    System.out.println("Image numbers are NOT consecutive");
                }
            }
            rh.getSentences();
        }

    }
}
