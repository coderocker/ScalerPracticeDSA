public class Sqrt {

    public static void main(String[] args) {
        System.out.println(sqrt(2));
    }

    public static int sqrt(int A) {
        long i=0;
        for (; i*i <= A; i++) {
            if(i*i == A) {
                return (int)i;
            }
        }
        return (int)(i-1);
    }
}
