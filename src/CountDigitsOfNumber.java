import java.util.Scanner;

public class CountDigitsOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            long n = sc.nextLong();
            System.out.println(getDigitCount(n));
        }
    }

    private static int getDigitCount(long n)  {
        int digits = 0;
        if(n==0) {
            return 1;
        }
        while (n > 0) {
            n = n/10;
            digits += 1;
        }

        return digits;
    }
}
