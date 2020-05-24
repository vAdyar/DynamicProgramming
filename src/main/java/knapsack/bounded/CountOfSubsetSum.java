package knapsack.bounded;

import utils.ArrayUtils;

import java.util.Arrays;

// Counting the number of subsets whose sum is given.
public class CountOfSubsetSum {

    public static Integer[][] countOfSubsetSum(int[] w, Integer[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                if( i==0 || j==0) {
                    if( i==0 )
                        t[i][j] = 0;
                    if( j==0 )
                        t[i][j] = 1;
                } else {
                    if( w[i-1] <= j) {
                        int include = t[i-1][j-w[i-1]];
                        int exclude = t[i-1][j];
                        t[i][j] = include + exclude;
                    } else
                        t[i][j] = t[i-1][j];
                }
            }
        }
        return t;
    }

    public static void main(String[] args) {
        int[] w = new int[] {1,3,7,9,6,4};
        int n = (int) Arrays.stream(w).count();

        int W = 15;

        Integer[][] t = new Integer[n+1][W+1];

        t=countOfSubsetSum(w,t);

        ArrayUtils.print(t);
        System.out.println(t[n][W]);

    }
}
