package javase01.t04.array;

//import java.lang.Math;

public class Array {

    private static double FindMax (double[] a){
        int l = a.length;
        if ((l%2)!=0) {System.out.println("Need even length of array!"); return 0;}
        else {
            double amax = a[0] + a[l-1];
            for (int i=1;2*i < l;i++){
                if (amax < (a[i] + a[l-i-1])) {amax = a[i] + a[l-i-1];}
            }
            return amax;
        }
    }

    public static void main (String[] args) {
        double[] a = {1,5.11,1.24,6.1,8.3,7,9,8.9};
        for (double x : a){System.out.print(x+" ");}
        System.out.println();
        System.out.println(FindMax(a));
    }
}
