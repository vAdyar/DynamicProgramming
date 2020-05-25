package longestCommonSequence;

import utils.ArrayUtils;

public class LCSRecursionMemorization {

    public static int lcs(char[] a, char[] b, int n, int m, Integer[][] t) {
        if( t[n][m] != -1)
            return t[n][m];

        if( n==0 || m==0 ) {
            t[n][m] = 0;
            return t[n][m];
        }
        if( a[n-1]==b[m-1] ) {
            t[n][m] = 1 + lcs(a, b, n - 1, m - 1, t);
            return t[n][m];
        }
        else {
            int include = lcs(a, b, n-1, m, t);
            int exclude = lcs(a, b, n, m-1, t);
            t[n][m] = Math.max(include,exclude);
            return t[n][m];
        }
    }

    public static void main(String[] args) {
        char[] a = "abcdeaf".toCharArray();
        char[] b = "abcefar".toCharArray();

        int n = a.length;
        int m = b.length;

        Integer[][] t = new Integer[n+1][m+1];
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = -1;

            }
        }

        System.out.println(lcs(a,b,n,m,t));
        ArrayUtils.print(t);
    }
}
