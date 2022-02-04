public class ArrayAndMaths {
    public static void main(String[] args) {

        System.out.println(lengthOfLongestConsecutive1s("010100110101"));

    }

    // More's Voting Algo
    // Majority element with frequency > N/2
    private static int getMajorityElement(int[] A) {
        int len = A.length;
        int element = A[0];
        int freq = 1;
        for (int i = 1; i < len; i++) {
            if(freq == 0) {
                element = A[i];
                freq = 1;
            } else if(element != A[i]) {
                freq --;
            } else {
                freq ++;
            }
        }

        int count =0;
        for (int i = 0; i < len; i++) {
            if(A[i] == element) {
                count++;
            }
        }
        if(count > len/2) {
            return element;
        }

        return -1;
    }


    // More's Voting Algo
    // Majority element with frequency > N/3


    private static int[] getMajorityElementNBy3(int[] A) {
        int[] result = new int[2];
        int len = A.length;
        int element1 = A[0];
        int freq1 = 0;
        int element2 = A[0];
        int freq2 = 0;
        int count1 =0;
        int count2 =0;
        for (int i = 0; i < len; i++) {
            if(freq1 == 0) {
                element1 = A[i];
                freq1 = 1;
            } else if(element1 == A[i]) {
                freq1 ++;
            } else if(freq2 == 0) {
                element2 = A[i];
                freq2 = 1;
            } else if(element2 == A[i]) {
                freq2 ++;
            } else {
                freq1 --;
                freq2 --;
            }
        }


        for (int i = 0; i < len; i++) {
            if(A[i] == element1) {
                count1++;
            }
            if(A[i] == element2) {
                count2++;
            }
        }
        if(count1 > len/3) {
            result[0] = element1;
        }
        if(count2 > len/3) {
            result[1] = element2;
        }

        return result;
    }

    // atmost swap single 0 with 1
    private static int lengthOfLongestConsecutive1s(String A) {
        int N = A.length();
        int ans = 0;
        int count1 =0;
        int count0 =0;
        for (int i = 0; i < N; i++) {
            if(A.charAt(i) == '1') {
                count1++;
            } else {
                count0++;
            }
        }
        if(count1 == N) {
            ans = count1;
            return ans;
        }
        if(count0 == N) {
            ans = 0;
            return ans;
        }
        System.out.println(ans);
        for (int i = 0; i < N; i++) {
            if(A.charAt(i) == '0') {
                int L =0;
                int R =0;
                // All the consecutive 1 from left Side
                for (int j = i-1; j >= 0; j--) {
                    if(A.charAt(j) == '1') {
                        L++;
                    } else {
                        break;
                    }
                }

                // All the consecutive 1 from right Side
                for (int j = i+1; j < N; j++) {
                    if(A.charAt(j) == '1') {
                        R++;
                    } else {
                        break;
                    }
                }

                int lr = L+R;
                if(lr < count1){
                    lr += 1;
                }
//                System.out.println(lr);
                ans = Math.max(ans, lr);
//                System.out.println(ans);

            }

        }
        return ans;
    }
}
