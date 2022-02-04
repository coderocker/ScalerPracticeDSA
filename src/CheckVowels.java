import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CheckVowels {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        System.out.println(isVowel(ch));
    }

    private static int isVowel(char ch) {
        List<Character> vowels = new ArrayList<Character>(Arrays.asList('a','e','i','o','u'));

        if(vowels.contains(ch)) {
            return 1;
        }

        return 0;
    }



    private static int calculatePercentage() {
        Scanner sc = new Scanner(System.in);

        int noOfSubjects = 5;
        int sum = 0;
        for(int i=1; i <= noOfSubjects; i++) {
            sum = sum + sc.nextInt();
        }
        return sum/5;
    }

    private static char getGrade(int percentage){
        char grade;
        if(percentage >= 90) {
            grade = 'A';
        } else if(percentage >=80) {
            grade = 'B';
        } else if(percentage >= 70) {
            grade = 'C';
        } else if(percentage >= 60) {
            grade = 'D';
        } else if(percentage >= 40) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        return grade;
    }
}
