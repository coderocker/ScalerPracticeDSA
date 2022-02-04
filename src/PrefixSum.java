import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrefixSum {
    public static void main(String[] args) {
//        System.out.println(eqIndex(new int[] {1}));
        System.out.println(subArrayWithLeastIndex(new int[] {20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11}, 9));
    }

    private static int[] prefixSum(int[] A) {
        int[] pf = new int[A.length];
        int sum =0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            pf[i] = sum;
        }

        return pf;
    }






    private static boolean isEqIndex(int[] pf, int index) {
        int left = index == 0 ? 0 : sumOfIToJthIndex(pf,0, index-1);
        int right = index == pf.length-1 ? 0 : sumOfIToJthIndex(pf, index+1, pf.length-1);
        return left == right;
    }

    private static ArrayList<Integer> eqIndex(int[] A) {
        if(A.length == 1) {
            return new ArrayList<>(List.of(0));
        }
        int[] pf = prefixSum(A);

        ArrayList<Integer> eqIndex= new ArrayList<Integer>();
        for (int i = 0; i < pf.length; i++) {
            if(isEqIndex(pf, i)) {
                eqIndex.add(i);
            }
        }
        return eqIndex;
    }


    private static int[] prefixEvenSum(int[] A) {
        int[] pf = new int[A.length];
        int sum =0;
        for (int i = 0; i < A.length; i++) {
            if(i%2 == 0)
                sum += A[i];
            pf[i] = sum;
        }

        return pf;
    }

    private static int[] prefixOddSum(int[] A) {
        int[] pf = new int[A.length];
        int sum =0;
        for (int i = 0; i < A.length; i++) {
            if(i%2 != 0)
                sum += A[i];
            pf[i] = sum;
        }

        return pf;
    }

    private static int sumOfIToJthIndex(int[] pf, int i, int j) {
        if(i==0)
            return pf[j];

        return pf[j] - pf[i-1];
    }


    private static boolean isSpIndex(int[] epf, int[] opf, int index) {
        int leftEven = index == 0 ? 0 : sumOfIToJthIndex(epf,0, index-1);
        int rightEven = index == epf.length-1 ? 0 : sumOfIToJthIndex(epf, index+1, epf.length-1);

        int leftOdd = index == 0 ? 0 : sumOfIToJthIndex(opf,0, index-1);
        int rightOdd = index == epf.length-1 ? 0 : sumOfIToJthIndex(opf, index+1, epf.length-1);

        int prefixEvenSum = (leftEven + rightOdd);
        int prefixOddSum = (leftOdd + rightEven);
        return prefixEvenSum == prefixOddSum;
    }

    private static ArrayList<Integer> specialIndex(int[] A) {
        int[] epf = prefixEvenSum(A);
        int[] opf = prefixOddSum(A);

        ArrayList<Integer> spIndex= new ArrayList<Integer>();
        for (int i = 0; i < A.length; i++) {
            if(isSpIndex(epf, opf, i)) {
                spIndex.add(i);
            }
        }

        return spIndex;
    }


    private static int subArrayWithLeastIndex(int[] A, int B) {
        int len = A.length;
        int[] pf = prefixSum(A);
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i=0; i< len; i++) {
            int j=i+(B-1);
            if(j >= len) {
                break;
            }
            int sum = sumOfIToJthIndex(pf, i, j);

            if(sum < min) {
                min = sum;
                minIndex = i;
            }
        }

        return minIndex;
    }
}
