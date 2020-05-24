package knapsack.bounded;

import utils.ArrayUtils;

public class SubsetSum {

    public static Boolean[][] subsetSum(int[] w, Boolean[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                if( i==0 || j==0 ) {
                    if (i == 0)
                        t[i][j] = false;
                    if (j == 0)
                        t[i][j] = true;
                } else {
                    if (w[i - 1] <= j) {
                        boolean include = t[i - 1][j - w[i-1]];
                        boolean exclude = t[i - 1][j];
                        t[i][j] = include || exclude;
                    } else
                        t[i][j] = t[i - 1][j];
                }
            }
        }
        return t;
    }

    public static void main(String[] args) {
        int[] w = new int[] {1,3,7};
        int W = 10;
        int n = w.length;

        Boolean[][] t = new Boolean[n+1][W+1];

        t = subsetSum(w, t);

        ArrayUtils.print(t);
        System.out.println(t[n][W]);
    }
}
