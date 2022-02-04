public class SpiralOrderMatrix2 {
    public static void main(String[] args) {
        System.out.println(generateMatrix(80));
    }

    public static int[][] generateMatrix(int A) {

        int[][] result = new int[A][A];
        int N = A;
        int element = 1;
        for(int k=0; k<A/2; k++) {
            int i=k, j=k;

            System.out.println("LeftToRight");
            for( ; j < N-1; j++, element++) {
                result[i][j] = element;
                System.out.println("\t" + k + "====>" + i + "===" + j);
            }

            System.out.println("TopToBottom");
            for( ; i < N-1; i++, element++) {
                result[i][j] = element;
                System.out.println("\t" + k + "====>" + i + "===" + j);
            }

            System.out.println("RightToLeft");
            for( ; j > k; j--, element++) {
                result[i][j] = element;
                System.out.println("\t" + k + "====>" + i + "===" + j);
            }

            System.out.println("BottomToUp");
            for( ; i > k; i--, element++) {
                result[i][j] = element;
                System.out.println("\t" + k + "====>" + i + "===" + j);
            }

            N -= 1;

//            System.out.println(i + "==" + j);
        }

        if(A%2 !=0 ) {
            int middleEl = A/2;
            result[middleEl][middleEl] = element;
        }

        return result;
    }
}
