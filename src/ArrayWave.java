import java.util.Scanner;

public class ArrayWave {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        int[][] arr = new int[R][C];

        for(int i=0; i< R; i++) {
            for(int j=0; j<C; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        wave(arr);
    }

    private static void wave(int[][] arr){
        int R = arr.length;
        int C = arr[0].length;

        for(int col=0; col < C; col++) {
            if(col%2 ==0) {
                for(int row=0; row < R; row++) {
                    System.out.println(arr[row][col] + " ");
                }
            } else  {
                for(int row=R-1; row <=0; row++) {
                    System.out.println(arr[row][col] + " ");
                }
            }
        }
    }
}
