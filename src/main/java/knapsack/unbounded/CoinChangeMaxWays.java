package knapsack.unbounded;

import utils.ArrayUtils;

import java.util.Arrays;

//  Coin Change Problem Maximum Number of ways
// Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
// how many ways can we make the change? The order of coins doesn’t matter.
public class CoinChangeMaxWays {

    public static Integer[][] maxCoinChange(int[] w, Integer[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                if( i==0 || j==0 ) {
                    if( i==0 )
                        t[i][j] = 0;
                    if( j==0 )
                        t[i][j] = 1;
                } else {
                    if( w[i-1] <= j) {
                        int include = t[i][j-w[i-1]];
                        int exclude = t[i-1][j];
                        t[i][j] = include + exclude;
                    } else
                        t[i][j] = t[i-1][j];
                }
            }
        }

        return t;
    }

//    Solving using count of subset sum with a variation
    public static void main(String[] args) {
        int[] w = {1,2,3};
        int W = 4;
        int n = (int) Arrays.stream(w).count();

        Integer[][] t = new Integer[n+1][W+1];
        t = maxCoinChange(w,t);

        ArrayUtils.print(t);


    }
}
