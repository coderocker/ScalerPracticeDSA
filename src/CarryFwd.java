public class CarryFwd {
    public static void main(String[] args) {
//        System.out.println(bulbs(new int[] {1,1,0,1}));

        System.out.println(evenPairsOfEvenLength(new int[] {978, 847, 95, 729, 778, 586, 188, 782, 813, 870, 871, 940, 312, 693, 580, 101, 760, 837, 564, 633, 680, 155, 241, 374, 682, 290, 850, 601, 433, 922, 773, 959, 530, 290, 990, 50, 516, 409, 868, 131, 664, 851, 721, 880, 20, 450, 745, 387, 787, 823, 392, 242, 674, 347, 65, 135, 819, 324, 651, 678, 139, 940}));
    }

    private static int minLengthOfSubArrWithMinMax(int[] arr) {
        int min = 6;
        int max = 10;
        int minIndex = -1;
        int maxIndex = -1;
        int ans =0;
        for (int i = 0; i < arr.length; i++) {

            if(arr[i] == min || arr[i] == max) {
                int minLength =0;
                if(arr[i] == min) {
                    minIndex = i;

                    if(maxIndex >0) {
                        minLength = maxIndex - minIndex + 1;
                    }

                } else if(arr[i] == max) {
                    maxIndex = i;

                    if(minIndex >0) {
                        minLength =  minIndex - maxIndex + 1;
                    }

                }
                if(minLength < ans) {
                    ans = minLength;
                }
            }
        }

        return ans;
    }

//    private static int bulbs(int[] A) {
//        int carry = -1;
//        int count = 0;
//        for (int i = 0; i < A.length; i++) {
//            if(carry != -1) {
//                A[i] = carry;
//            }
//            if(A[i] == 0) {
//                A[i] = 1;
//                carry = 0;
//                count ++;
//            } else {
//                carry = 1;
//            }
//        }
//        return count;
//    }


//    private static int bulbs(int[] A) {
//        int carry = 1;
//        int ans = 0;
//        for (int i = A.length -1; i >=0; i--) {
//            carry++;
//            if(A[i] == 0) {
//                ans+=carry;
//                carry--;
//            }
//
//        }
//        return ans;
//    }


    private static int bulbs(int[] A) {
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            if(ans % 2 == 0) {
                if(A[i] == 0) {
                    ans++;
                }
            } else {
                if(A[i] == 1) {
                    ans++;
                }
            }

        }
        return ans;
    }

    private static String evenPairsOfEvenLength(int[] A) {
        int len = A.length;

        if(len < 2 || len % 2 !=0 || A[0] % 2 !=0 || A[len-1] % 2 != 0) {
            return "NO";
        }
        return "YES";
    }

}
