public class ArrayLeanerSearch {

    public static void main(String[] args) {

    }

    private static int[] search(int[] arr, int searchEl) {
        int[] resultArr = new int[arr.length + 1];
        int j=0;
        for(int i=0 ; i< arr.length; i++) {
            if(arr[i] == searchEl) {
                resultArr[j] = i;
                j++;
            }
        }

        resultArr[j] = -1;
        return  resultArr;
    }
}
