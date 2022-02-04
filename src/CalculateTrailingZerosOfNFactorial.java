import java.util.Scanner;

public class CalculateTrailingZerosOfNFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();



        System.out.println(getTrailingZeros(N));

    }

    private static int getTrailingZeros(long N){
        int power = 5;
        int zeros = 0;
        while (N/power > 0) {
            zeros += N/power;
            power = power * 5;
        }

        return zeros;
    }


}
