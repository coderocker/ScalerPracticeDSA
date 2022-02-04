public class KthSmallestElement {
    public static void main(String[] args) {
        KthSmallestElement kse = new KthSmallestElement();
        System.out.println(kse.kthsmallest(new int[]{2, 1, 4, 3, 2}, 3));

    }

    public int kthsmallest(final int[] A, int B) {
        int smallEl =0;
        for(int i=0; i<B; i++) {
            int index =0;
            int smEl=Integer.MAX_VALUE;
            for(int j=0; j<A.length; j++) {
                if (A[j] > 0 &&  A[j] <= smEl ) {
                    smEl = A[j];
                    index = j;
                }
            }

            A[index] = -1;
            smallEl = smEl;
        }
        return smallEl;
    }
}
