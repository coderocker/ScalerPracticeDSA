public class BeggarsProblem {
    public static void main(String[] args) {

    }

    public int[] solve(int A, int[][] B) {
        int[] beggars = new int[A];

        for (int[] ints : B) {
            for (int j = ints[0] - 1; j < ints[1]; j++) {
                beggars[j] += ints[2];
            }
        }
        return beggars;
    }
}
