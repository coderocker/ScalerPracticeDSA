import java.util.ArrayList;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(fib(n, new ArrayList<Integer>()));
    }

    private static int fib(int n, ArrayList<Integer> fibo) {
        if(n < fibo.size()) {
            return fibo.get(n);
        }

        if(n < 1) {
            return 0;
        }

        if(n == 1) {
            return 1;
        }

        fibo.add(fib(n, fibo) + fib(n, fibo));
        return fibo.get(n);
    }
}
