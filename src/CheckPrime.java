import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        if(isPrime(number)) {
            System.out.println(number + " is a prime number");
        } else {
            System.out.println(number + " is not a prime number");
        }
    }

    private static boolean isPrime(int number) {
        int i = 2;
        while ((i*i) <= number) {
            if(number % i == 0) {
                return false;
            }

            i += 1;
        }

        return true;
    }
}
