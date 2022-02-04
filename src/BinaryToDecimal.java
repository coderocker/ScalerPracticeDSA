public class BinaryToDecimal {
    public static void main(String[] args) {

        decimalToBinary(18);

    }

    private static int power(int number, int pow) {
        if(pow == 0) {
            return 1;
        }

        return number * power(number, pow-1);
    }


    private static int binaryToDecimal(int N) {
        int ans = 0;
        int pow = 1;

        while (N > 0) {
            int lastDigit = N%10;
            ans = ans + lastDigit * pow;
            pow = pow * 2;

            N = N/10;
        }

        return ans;
    }

    private static int decimalToBinary(int N) {
        int ans = 0;
        int pow = 1;

        while (N > 0) {
            int lastBit = N%2;
            System.out.println("lastBit " + lastBit);
            ans = ans + lastBit * pow;
            System.out.println("Ans " + ans);
            pow = pow * 10;

            N = N/2;
        }

        return ans;
    }




    private static int magicNumber(int N) {
        int ans = 0;
        int pow = 5;

        while (N > 0) {
            int lastBit = N%2;
            ans = ans + lastBit * pow;
            pow = pow * 5;

            N = N/2;
        }

        return ans;
    }


    private static int getTrailingZeros(int N) {
        int ans = 0;
        int pow = 1;

        int zerosCount = 0;
        while (N > 0) {
            int lastBit = N%2;
            if(lastBit == 0) {
                zerosCount += 1;
            } else {
                return zerosCount;
            }
            ans = ans + lastBit * pow;
            pow = pow * 10;

            N = N/2;
        }

        return zerosCount;
    }
}
