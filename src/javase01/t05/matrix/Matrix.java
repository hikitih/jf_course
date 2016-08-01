package javase01.t05.matrix;

public class Matrix {

    private static void DrawMatrix(int n){
        int x;
        int i = 1;
        while (i<=n) {
            int j = 1;
            while (j<=n) {
                if ((i==j)||(n==i+j-1)) {x=1;}
                else {x=0;}
                System.out.print(x+" ");
                j++;
            }
            System.out.println();
            i++;
        }
    }

    public static void main(String[] args) {
        DrawMatrix(12);
    }
}