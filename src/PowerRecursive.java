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


}
