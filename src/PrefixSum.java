import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    private static int[] buildArrayWithQueries(int N, int[][] Q) {
        int[] A = new int[N];

        for(int i=0; i < Q.length; i++) {
            int index = Q[i][0];
            int value = Q[i][1];
            A[index] += value;
        }

        // Pfsum
        for (int i=1; i < N; i ++) {
            A[i] += A[i-1] + A[i];
        }

        return A;
    }

    private static int[] buildArrayWithQueriesStEnd(int N, int[][] Q) {
        int[] A = new int[N];

        for(int i=0; i < Q.length; i++) {
            int stIndex = Q[i][0];
            int endIndex = Q[i][1];
            int value = Q[i][2];
            A[stIndex] += value;
            A[endIndex + 1] -= value;
        }

        // Pfsum
        for (int i=1; i < N; i ++) {
            A[i] += A[i-1] + A[i];
        }

        return A;
    }

    // Prefix max
    private static int[] prefixMax(int[] A) {
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            max = Math.max(max, A[i]);
            A[i] = max;
        }

        return A;
    }

    // Sufix max
    private static int[] suffixMax(int[] A) {
        int N = A.length;
        int max = A[N-1];
        for (int i = N-2; i >= 0; i--) {
            max = Math.max(max, A[i]);
            A[i] = max;
        }

        return A;
    }

    // water accumulated on building problems
    private static int totalWater(int[] A, int N) {
        int[] prefixMax = prefixMax(A);
        int[] suffixMax = suffixMax(A);

        int totalWater = 0;
        // Starts with 1 and ends before N-1 because no water will be accumulated on corner buildings
        for (int i = 1; i < N-1; i++) {
            totalWater += Math.min(prefixMax[i-1], suffixMax[i+1]) - A[i];
        }
        return totalWater;
    }
}
