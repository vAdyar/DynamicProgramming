package knapsack.unbounded;

import utils.ArrayUtils;
// Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
// Determine the  maximum value obtainable by cutting up the rod and selling the pieces.
public class RodCutting {

    public static Integer[][] unboundedKnapSack(int[] len, int[] price, Integer[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                if( i==0 || j==0 )
                    t[i][j] = 0;
                else {
                    if ( len[i-1] <= j ) {
                        int include = price[i-1] + t[i][j-len[i-1]];
                        int exclude = t[i-1][j];
                        t[i][j] = Math.max(include,exclude);
                    } else
                        t[i][j] = t[i-1][j];
                }
            }
        }

        return t;
    }

    public static void main(String[] args) {
        int[] len = {1,3,5,2};
        int[] price = {10, 40,30,100};
        int logLength = 100;
        int n = len.length;

        Integer[][] t = new Integer[n+1][logLength+1];
        t = unboundedKnapSack(len, price, t);
        ArrayUtils.print(t);
        System.out.println("Max price is: "+t[n][logLength]);
    }
}
