package knapsack.bounded;

import utils.ArrayUtils;

import java.util.Random;

public class DynamicArray {

    public static Integer[][] maxSum(int[] w, Integer[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if( i==0 || j==0) {
                    t[i][j] = 0;
                } else {
                    if (w[i - 1] <= j) {
                        int include = w[i-1] + t[i - 1][j - w[i-1]];
                        int exclude = t[i - 1][j];
                        t[i][j] = Math.max(include, exclude);
                    } else
                        t[i][j] = t[i - 1][j];
                }
            }
        }
        return t;
    }

    public static void main(String[] args) {
        Random random = new Random();

        int[] w = new int[] {1,3,7,2};
//        int[] value = new int[] {10, 20, 30};
        int W = 11;
//        int[] value = random.ints(100000, 10, 100).toArray();
//		int[] w = random.ints(100000, 10, 100).toArray();
//        int W = 100;
        int n = w.length;

        Integer[][] t = new Integer[n+1][W+1];

        t = maxSum(w, t);

        ArrayUtils.print(t);
        System.out.println(t[n][W]);

    }
}
