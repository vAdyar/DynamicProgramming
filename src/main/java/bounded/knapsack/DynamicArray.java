package bounded.knapsack;

import java.util.Random;

public class DynamicArray {

    private static void print(int[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }


    public static void main(String[] args) {
        Random random = new Random();

//        int[] weight = new int[] {1,3,7};
//        int[] value = new int[] {10, 20, 30};
//        int W = 11;
        int[] value = random.ints(100000, 10, 100).toArray();
		int[] weight = random.ints(100000, 10, 100).toArray();
        int W = 100;
        int n = weight.length;

        int[][] t = new int[n+1][W+1];

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if( i==0 || j==0) {
                    t[i][j] = 0;
                } else {
                    if (weight[i - 1] <= W) {
                        int include = value[i - 1] + t[i - 1][j - 1];
                        int exclude = t[i - 1][j];
                        t[i][j] = Math.max(include, exclude);
                    } else
                        t[i][j] = t[i - 1][j];
                }
            }
        }

        print(t);
        System.out.println(t[n][W]);

    }
}
