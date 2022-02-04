import java.math.BigInteger;
import java.util.Arrays;

public class PascaleTriangle {
    private final BigInteger[] factArr = new BigInteger[500];

    public static void main(String[] args) {
        PascaleTriangle T = new PascaleTriangle();
        int[][] pt = T.solve(25);


      //  System.out.println(T.nCr(25,23));
//        BigInteger factOfN = T.fact(25);
//        BigInteger factOfR = T.fact(21);
//        BigInteger factOfNMinR = T.fact(25-21);
//
//        System.out.println(factOfN);
//        System.out.println(factOfR);
//        System.out.println(factOfNMinR);
//        System.out.println(factOfN.divide(factOfR));
//        System.out.println(factOfN.divide(factOfR).divide(factOfNMinR));

        System.out.println(Arrays.deepToString(pt));
    }

    public int[][] solve(int A) {
        int[][] resultArr = new int[A][A];

        for(int n=0; n<A; n++){
            for(int r=0; r<A; r++) {
                if(n==r) {
                    resultArr[n][r] = 1;
                } else if(n < r) {
                    resultArr[n][r] = 0;
                } else {
                    resultArr[n][r] = (int)nCr(n, r);
                }
            }
        }

        return resultArr;
    }

    private BigInteger fact(int n) {
        if(n <= 1) {
            return BigInteger.ONE;
        } else if(factArr[n] != null ) {
            return factArr[n];
        }

        factArr[n] = fact(n-1).multiply(BigInteger.valueOf(n));
        return factArr[n];
    }

    private int nCr(int n, int r) {
        return (fact(n).divide(fact(r))).divide(fact(n - r)).intValue();
    }
}
