public class Sorting {
    public static void main(String[] args) {


    }

    private static boolean comparator(int a, int b) {
        int da = digitCount(a);
        int db = digitCount(b);

        if(da < db) {
            return true;
        } else if(da >  db) {
            return false;
        } else {
            if (a < b)
                return false;
            else
                return true;
        }
    }

    private static int digitCount(int num){
        int digitCount = 0;
        while (num > 0) {
            num = num/10;
            digitCount++;
        }
        return digitCount;
    }
}
