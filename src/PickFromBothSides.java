public class PickFromBothSides {

    public static void main(String[] args) {
        int[] A = new int[] {-712, -894, 40, -58, 264, -352, 446, 805, 890, -271, -630, 350, 6, 101, -607, 548, 629, -377, -916, 954, -244, 840, -34, 376, 931, -692, -56, -561, -374, 323, 537, 538, -882, -918, -71, -459, -167, 115, -361, 658, -296, 930, 977, -694, 673, -614, 21, -255, -76, 72, -730, 829, -223, 573, 97, -488, 986, 290, 161, -364, -645, -233 };
        int B = 34;

        System.out.println(solve(A, B));
    }

    public static int solve(int[] A, int B) {
        int N = A.length;
        System.out.println(N);
        int sum = 0;
        for(int i= N-B; i < N; i++ ) {
            sum += A[i];
        }

        int ans = sum;

        int s = N - B + 1;
        int e = s + B - 1;
        if(s >= N) {
            s = 0;
        }
        if(e >= N) {
            e = 0;
        }



        while(s==0 || s > N-B) {
            if(s >= N) {
                s = 0;
            }

            if(e >= N) {
                e = 0;
            }

            int lastStartIndex = (s == 0) ? N - 1: s-1;
            System.out.println(e);
            sum = sum + A[lastStartIndex] + A[e];

            ans = Math.max(ans, sum);

            s++;
            e++;
        }

        return ans;

    }
}
