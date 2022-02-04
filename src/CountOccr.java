class CountOccr {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,5,10,5,6,3,8,9};
        countOccr(arr);
    }

    private static void countOccr(int[] arr) {
        int[] visited = new int[arr.length];
        for(int i=0, k=0; i<arr.length; i++) {
            int occrCount =0;
            for(int j=0; j<arr.length; j++) {
                if(!isVisited(visited, arr[j]) && arr[i] == arr[j]) {
                    occrCount++;
                }
            }
            if(!isVisited(visited, arr[i])) {
                System.out.println(arr[i] + " " + occrCount + " times");
                visited[k] = arr[i];
                k++;
            }
        }
    }

    private static boolean isVisited(int[] visited, int element) {
        for(int i=0; i<visited.length; i++) {
            if(visited[i] == element) {
                return true;
            }
        }

        return false;
    }
}