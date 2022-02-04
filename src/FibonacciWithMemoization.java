import java.util.Scanner;

public class FibonacciWithMemoization {

    public static long fibArray[]=new long[200];
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 1; i <= T; i++) {
            long N = sc.nextLong();

            if(isFiboNo(N)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean isFiboNo(long N) {
        int j = 0;
        long fib;
        while((fib = fibo(j)) <= N) {
            if(fibo(j) == N) {
                return true;
            }
            j += 1;
        }
        return false;
    }


    private static long fibo(long N) {
        long fibValue=0;
        if(N < 1) {
            return 0;
        } else if(N == 1) {
            return 1;
        } else if(fibArray[(int)N]!=0) {
            return fibArray[(int)N];
        }

        fibValue = fibo(N-2) + fibo(N-1);
        fibArray[(int)N]=fibValue;
        return fibValue;
    }
}
