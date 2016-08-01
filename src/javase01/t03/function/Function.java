package javase01.t03.function;

import java.lang.Math;

public class Function {

    public static void FunctionValues (double a,double b,double h){
        if ((a<b)&&(h>0)) {
            System.out.print("Argument\t     Value\n");
            while (a < b) {
                System.out.printf("%8.1f"+"\t",a);
                System.out.printf("%10.3f%n",(Math.tan(2 * a) - 3));
                a += h;
            }
        } else {System.out.println("Incorrect values of a, b, h");}
    }

    public static void main (String[] args) { Function.FunctionValues(1,3,0.2);}
}
