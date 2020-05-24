package knapsack.unbounded;

import utils.ArrayUtils;

import java.util.Arrays;

// Coin Change Problem Minimum Numbers of coins
// Given a value V, if we want to make change for V cents,
// and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins, what is the minimum number of coins to make the change?
public class CoinChangeMinCoins {

    public static Integer[][] minCoins(int[] coins, Integer[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if( i==0 || j==0){
                    if( i==0 )
                        t[i][j] = Integer.MAX_VALUE-1;
                    if( j==0)
                        t[i][j] = 0;
                } else {
                    if( coins[i-1] <= j ) {
                        int include = t[i][j-coins[i-1]] + 1;
                        int exclude = t[i-1][j];
                        t[i][j] = Math.min(include,exclude);
                    } else
                        t[i][j] = t[i-1][j];
                }
            }

        }

        return t;
    }

    public static int minCoinsRecursive(int[] coins, int n, int V) {
        if (n == 0 || V == 0)
            if (n == 0)
                return Integer.MAX_VALUE - 1;
        if (V == 0)
            return 0;
        if (coins[n - 1] <= V) {
            int include = minCoinsRecursive(coins, n, V - coins[n - 1]) + 1;
            int exclude = minCoinsRecursive(coins, n - 1, V);
            return Math.min(include, exclude);
        } else
            return minCoinsRecursive(coins, n - 1, V);
    }

    public static void main(String[] args) {
        int[] coins =  {2, 3, 4};
        int V = 7;
        int n = (int) Arrays.stream(coins).count();

        Integer[][] t = new Integer[n+1][V+1];
        t=minCoins(coins,t);

        ArrayUtils.print(t);

        System.out.println("Dynamic array: "+t[n][V]);
        System.out.println("Recursive: "+minCoinsRecursive(coins, n, V));
    }

}
