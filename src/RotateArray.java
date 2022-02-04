import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i=0; i<N ; i++) {
            arr[i] = sc.nextInt();
        }
        int rotateTimes = sc.nextInt();

        /*int[] arr = {1,2,3,4};

        int N= arr.length;
        int rotateTimes = 5;*/

        rotateArray(arr, N, rotateTimes);

        for (int i=0; i<N ; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    private static int[][] rotateMultiple(int[] A, int[] B) {
        reverseArray(A);
        int[][] result = new int[B.length][A.length];
        for(int i=0; i<B.length; i++) {
            int[] newArr = A.clone();
            rotateArray(newArr, A.length, B[i]);
            result[i] = newArr;
        }
        return result;
    }

    private static void rotateArray(int[] arr, int N, int rotateTimes) {

        if(rotateTimes >= N) {
            rotateTimes = rotateTimes % N;
        }
        if(rotateTimes !=0) {
            reverseArray(arr);
            reverseArray(arr,0, rotateTimes-1);
            reverseArray(arr, rotateTimes, N-1);
        }

    }

    private static void reverseArray(int[] arr) {
        reverseArray(arr, 0, arr.length-1);
    }

    private static void reverseArray(int[] arr, int stIndex, int endIndex) {
        for(int i=stIndex, j=endIndex; i<j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    private static void minMax(int[] arr, int N) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            if(arr[i] > max)
                max = arr[i];
            if(arr[i] < min)
                min = arr[i];
        }

        System.out.print(max + " " + min);
    }


    private static int secondLargest(int[] arr, int N) {
        if(N <= 1)
            return -1;
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;

        for (int i = 0; i < N; i++) {
            if(arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if(i == maxIndex) {
                continue;
            }

            if(arr[i] > max)
                max = arr[i];
        }

        return max;
    }

    private static int isPresent(int[] A, int B) {
        for (int i = 0; i < A.length; i++) {
            if(A[i] == B) {
                return 1;
            }
        }
        return 0;
    }

    private int minOperationToMakeMax(int[] A, int B) {
        int opCount=0;
        boolean bExists = false;
        for (int i = 0; i < A.length; i++) {
            if(A[i] == B) {
                bExists = true;
            }
            if(A[i] > B) {
                opCount++;
            }
        }
        if(!bExists)
            opCount = -1;

        return opCount;
    }



}
