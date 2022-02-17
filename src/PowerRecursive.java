public class PowerRecursive {
    public static void main(String[] args) {
        System.out.println(power(5,4));
        System.out.println(multiply(3,4));



    }

    // base case: number having power 0 is 1
    //Recursive case:  power(number,pow) = number * power(number,pow-1)
    private static int power(int number, int pow) {
        if(pow == 0) {
            return 1;
        }

        return number * power(number, pow-1);
    }

    private static int multiply(int number1, int number2) {
        if(number2 == 0) {
            return 0;
        }

        return number1 + multiply(number1, number2-1);
    }

    // With log(N) complexity
    private static int powerOp(int a, int N) {
        if(N == 0) {
            return 1;
        }

        int he = powerOp(a, N/2);
        int ha = he * he;

        if((N % 2) == 0) {
            return ha;
        } else {
            return ha * a;
        }
    }

    private static long powerOpMod(int a, int N, int p) {
        if(N == 0) {
            return 1;
        }

        long he = powerOp(a, N/2);
        long ha = ((he % p) * (he % p)) % p;

        if((N % 2) == 0) {
            return ha;
        } else {
            return ((ha % p) * (a % p)) % p;
        }        
    }

}
