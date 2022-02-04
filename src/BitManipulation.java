import java.util.ArrayList;
import java.util.Arrays;

public class BitManipulation {
    public static void main(String[] args) {
        String A = "1";
        String B = "1";

//        System.out.println(addBinary(A, B));
//        System.out.println((4 >> 2) & 1);
//        System.out.println(helpFromSam(4));

//        System.out.println(8 ^ 7 ^ 11 ^ 6 ^ 2 ^ 10);
//
//        System.out.println(reverseBit(3));
        // 0011
//        System.out.println((0 << 0) | (0 << 31));
//        System.out.println(1 & 1);
        long a = 1;
//
//        System.out.println(Long.toBinaryString((a<< 0) | (a<<31)));
//        System.out.println(Long.toBinaryString((a<< 0)));
//        System.out.println(Long.toBinaryString((a<< 31)));

//        System.out.println(1 & 3);
//        System.out.println(3 | 5);
        System.out.println((3 ^ 4) ^ 2);

    }


    public static String addBinary(String A, String B) {
        int aLen = A.length();
        int bLen = B.length();
        int maxLen = Math.max(aLen, bLen);
        char[] res = new char[maxLen + 1];
        int sum =0;
        int carry =0;
        for(int i=aLen-1, j=bLen-1, k=res.length-1; (i >= 0 || j >= 0 || carry != 0); i--, j--, k--) {
            sum = carry;
            if(i >= 0) {
                sum += (A.charAt(i) - '0');
            }
            if(j >= 0) {
                sum += (B.charAt(j) - '0');
            }

            res[k] = (char) ((sum % 2) + '0');
            carry = sum/2;
        }


        if(res[0] == '1') {
            return new String(res);
        }
        return new String(res, 1, maxLen);

    }


    private static int helpFromSam(int A) {
        int ans = 0;
        for(int i=0; i < 32; i++) {
            if(checkBit(A, i)) {
                ans++;
            }
        }

        return ans;
    }

    private static boolean checkBit(int N, int i) {
        return ((N >> i) & 1) == 1;
    }

    private static String interestingArray(int[] A) {
        int oddElCount = 0;
        for (int i = 0; i < A.length; i++) {
            if(!isEven(A[i])) {
                oddElCount++;
            }
        }

        if(isEven(oddElCount)) {
            return "Yes";
        }
        return "No";
    }

    private static boolean isEven(int n) {
        return (n & 1)!=1;
    }
    private static boolean isPowerOf2(int n) {
        return (n & n-1) == 0;
    }


    private static long reverseBit(long a) {
        for(int i=0, j=31; i < j; i++, j--) {
//            System.out.println("==============================================");
            a = swapBits(a, i, j);
//            System.out.println("==============================================");
        }
        return a;
    }

    private static long swapBits(long n, int p1, int p2) {
//        System.out.println("Number : " + Long.toBinaryString(n));
        long bit1 = (n >> p1) & 1;
        long bit2 = (n >> p2) & 1;
//        System.out.println("bit1 : " + bit1);
//        System.out.println("bit2 : " + bit2);

        long x = bit1 ^ bit2;
//        System.out.println("bit1 ^ bit2 : " + bit1 + "^" + bit2 + " = " + Long.toBinaryString(x));


//        System.out.println("(x << p1) | (x << p2) : (" + Long.toBinaryString(x) + "<< " + p1 + ") | (" + Long.toBinaryString(x) + "<<" + p2 + ") = " + Long.toBinaryString((x << p1) | (x << p2)));
        x = (x << p1) | (x << p2);

//        System.out.println("n ^ x : " + Long.toBinaryString(n) + "^" + Long.toBinaryString(x) + " = " +  Long.toBinaryString(n ^ x));

        return n ^ x;
    }


    private static int bitCompression(int[] A) {
        int len = A.length;
        for (int i = 0, j = 1; j < len; i++, j++) {
            int ai = A[i];
            A[i] = A[i] & A[j];
            A[j] = ai | A[j];
        }

        int xor = 0;

        for (int i = 0; i < len; i++) {
            xor ^= A[i];
        }

        return xor;
    }


}
