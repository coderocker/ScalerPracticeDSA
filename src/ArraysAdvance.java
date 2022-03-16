public class ArraysAdvance {
    public static void main(String[] args) {

    }

    private static int[] plusOne(int[] A) {
        int N = A.length;

        int i = N-1;
        int carry = 1;

        while (carry > 0 && i >= 0) {
            int s = A[i] + carry;
            A[i] = s % 10;
            carry = s / 10;
            i--;
        }
        int[] result;
        if(carry != 0) {
            result = new int[N+1];
            result[0] = carry;
            System.arraycopy(A, 0, result, 1, N);
            return result;
        }

        int j=0;
        while (A[j] == 0) {
            j++;
        }

        if(j > 0) {
            int size = N-j;
            result = new int[size];
            System.arraycopy(A, j, result, 0, size);
            return result;
        }

        return A;
    }
}
