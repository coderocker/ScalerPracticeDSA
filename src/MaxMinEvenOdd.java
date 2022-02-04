import java.util.ArrayList;

public class MaxMinEvenOdd {

    public static void main(String[] args) {
        System.out.println(maxMinEvenOdd(new int[]{-98, 54, -52, 15, 23, -97, 12, -64, 52, 85 }));
    }

    private static int maxMinEvenOdd(int[] A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {

            if (Math.abs(A[i]) % 2 == 0) {
                if (A[i] > max) {
                    max = A[i];
                }
            } else {
                if(A[i] < min) {
                    min = A[i];
                }
            }

        }

        if(max == Integer.MIN_VALUE)
            max =0;

        if(min == Integer.MAX_VALUE)
            min =0;

        return (max-min);
    }


    private static void printOddEvenInSeparateArrays(int[] A, int N) {
        ArrayList<Integer> O= new ArrayList<Integer>();
        ArrayList<Integer> E= new ArrayList<Integer>();

        for (int i = 0; i < N; i++) {
            if(Math.abs(A[i]) % 2 == 0) {
                E.add(A[i]);
            } else {
                O.add(A[i]);
            }
        }

        O.forEach((n) -> System.out.print(n + " "));
        System.out.println();
        E.forEach((n) -> System.out.print(n + " "));
        System.out.println();

    }
}
