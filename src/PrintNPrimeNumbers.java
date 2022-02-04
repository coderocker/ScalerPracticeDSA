import java.util.Scanner;

public class PrintNPrimeNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        printPrimeNPrimeNumbers(n);
    }

    private static void printPrimeNPrimeNumbers(int n){
        for (int i=2; i<=n; i++) {
            if(isPrime(i)) {
                System.out.println(i);
            }
        }
    }
    private static boolean isPrime(int n) {
        for (int i=2; i*i <= n; i++) {
            if(n%i ==0) {
                return false;
            }
        }
        return true;
    }
}
