import java.util.Arrays;

public class LittlePonnyMobilePhones {
    public static void main(String[] args) {
        LittlePonnyMobilePhones lpmp = new LittlePonnyMobilePhones();
        System.out.println(Arrays.toString(lpmp.solve(new int[] {3,4,4,6}, new int[] {20,4,10,2})));
    }

    public int[] solve1(int[] A, int[] B) {
        int[] result = new int[B.length];
        for(int i=0, j=B.length-1; i<=j; i++, j--) {
            for(int k=0, sum=0; k<A.length; k++) {
                sum += A[k];
                if(sum <= B[i]) {
                    result[i] += 1;
                }
            }
            if(i < j) {
                for(int k=0, sum=0; k<A.length; k++) {
                    sum += A[k];
                    if(sum <= B[j]) {
                        result[j] += 1;
                    }
                }
            }
        }
        return result;
    }


    public int[] solve(int[] A, int[] B) {
        A = prefixSum(A);
        int[] result = new int[B.length];
        for(int i=0, j=B.length-1; i<=j; i++, j--) {
            result[i] = binarySearch(A, B[i]);
            if(i < j) {
                result[j] = binarySearch(A, B[j]);
            }
        }
        return result;
    }

    private int binarySearch(int[] ps, int el) {
        int l=0, r= ps.length-1;


        while (l <= r) {
            int mid = l + (r - l)/2;
            if(ps[mid] == el) {
                return mid + 1;
            }

            if(ps[mid] < el) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return l;

    }

    private int[] prefixSum(int[] A) {
        int l = A.length;
        int[] result = new int[l];
        int sum = 0;
        for (int i=0;i<l; i++) {
            sum += A[i];
            result[i] = sum;
        }
        return result;
    }
}
