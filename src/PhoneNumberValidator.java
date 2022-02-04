import java.util.Scanner;

public class PhoneNumberValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String phoneNumber = sc.nextLine();
        System.out.println(validate(phoneNumber));
    }

    private static boolean validate(String phoneNo) {

        int startIndex = 0;
        if(phoneNo.startsWith("+91") || phoneNo.startsWith("091")) {
            startIndex = 3;
        } else if(phoneNo.startsWith("0")) {
            startIndex = 1;
        }

        int count = 0;
        for(int i=startIndex; i < phoneNo.length(); i++){
            if(phoneNo.charAt(i) == ' ' || phoneNo.charAt(i) == '-') {
                continue;
            }
            try {
                Integer.parseInt(String.valueOf(phoneNo.charAt(i)));
            } catch (Exception e) {
                return false;
            }
            count ++;
        }

        if(count != 10) {
            return false;
        }
        return true;
    }
}
