public class OrderRecursion {

    public static void main(String[] args) {
        inc(5);
    }

    private static void inc(int n) {
        if(n == 0) {
            return;
        }
        inc(n-1);
        System.out.println(n);
        return;
    }

    private static void desc(int n) {
        if(n == 0) {
            return;
        }

        System.out.println( "" + n);
        desc(n-1);
        return;
    }
}
