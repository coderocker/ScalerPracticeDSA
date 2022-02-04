import java.util.Scanner;

public class PrimeFactors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        printPrimeFactors(n);
    }

    private static void printPrimeFactors(int n) {
        for(int i=2; i <= n; i++) {
            if(n % i == 0) {
                System.out.print(i);
                System.out.print(" * ");
                printPrimeFactors(n/i );
                return;
            }
        }
    }
}
