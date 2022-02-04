public class NumberOFElementsGraterThanItself {
    public static void main(String[] args) {

    }

    private static int getNumberOfEl(int[] arr){
        int countOfMax=0;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == max) {
                countOfMax++;
            }
            if(arr[i] > max) {
                max = arr[i];
                countOfMax = 1;
            }

        }
        return countOfMax;
    }

    private static boolean pairExist(int[] arr,int k) {
        for (int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] + arr[j] == k) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int[] reverseArray(int[] arr) {
        for(int i=0, j=arr.length-1; i<j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return  arr;
    }
}
