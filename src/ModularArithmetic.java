public class ModularArithmetic {

    public static void main(String[] args) {

    }

    private static long bigPowerMod(int a, int power, int modulo) {
        long ans  = 1;
        for(int i=0; i < power; i++) {
            ans = (ans * a) % modulo;
        }

        return ans;
    }

    // TC O(N^2) solution
    private static long googleProblem(int[] A, int modulo) {
        long ans = 0;
        long exp = 1;
        int N = A.length;
        for (int i = 0; i < N ; i++) {
            ans = ans + (A[i] * bigPowerMod(10, N-i-1, modulo)) % modulo;
            ans = ans % modulo;

            exp = (exp + 10) % modulo;
        }

        return ans;
    }

    // TC O(N) solution with Carry fwd
    private static long googleProblemOptimised(int[] A, int modulo) {
        long ans = 0;
        long exp = 1;
        for (int i = A.length -1; i >= 0 ; i--) {
            ans = ans + ((A[i] * exp) % modulo);
            ans = ans % modulo;

            exp = (exp + 10) % modulo;
        }

        return ans;
    }


//    private static
}
