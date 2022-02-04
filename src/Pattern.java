import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String c = sc.next();
        int rowNum = 1;

        while (rowNum <= n) {
            printPattern(n, rowNum, c   );
            rowNum += 1;
        }
        rowNum = n-1;
        while (rowNum > 0) {
            printPattern(n, rowNum, c);
            rowNum -= 1;
        }
    }

    private static void printPattern(int n, int rowNum, String c){
        printSpace(n, rowNum);
        printChar(rowNum, c);
        System.out.print("\n");
    }

    private static void printSpace(int n, int rowNum){
        int space = 1;
        while (space <= (n - rowNum)) {
            System.out.print(" ");
            space += 1;
        }

    }

    private static void printChar(int rowNum, String c){
        int star = 1;
        while (star <= (2*rowNum - 1)) {
            System.out.print(c);
            star += 1;
        }
    }
}
