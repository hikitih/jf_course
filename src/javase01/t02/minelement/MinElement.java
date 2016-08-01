package javase01.t02.minelement;

import static java.lang.Math.pow;

public class MinElement {

    public static int FindMin(double epsilon){
        int n = 1;
        double a = 1/pow(n+1,2);
        while (a>epsilon) {
            System.out.print(" " + a);
            n += 1;
            a = 1/pow(n+1,2);
        }
        return n;
    }

    public static void main (String[] args) {
        System.out.println("\nMinimum = " + FindMin(0.1));
        }
    }