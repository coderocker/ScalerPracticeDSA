import java.util.Scanner;

public class PrintReverse {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter number or exit program by typing exit");
            Scanner sc = new Scanner(System.in);

            String input = sc.next();

            if(input.matches("(?i)exit|quit")) {
                System.out.println("Exiting from program, bbye!");
                break;
            }

            try {
                int number = Integer.parseInt(input);
                printReverse(number);
            } catch (NumberFormatException e) {
                System.out.println("Not a correct number.");
            }
        }


    }

    private static void printReverse(int number) {

        int reverse = 0;

        while (number > 0) {
            int remainder = number % 10;
            reverse = getReverse(reverse, remainder);
            number = number / 10;
        }

        System.out.println(reverse);
    }

    private static int getReverse(int reverse, int remainder){
        return (reverse * 10) + remainder;
    }
}
