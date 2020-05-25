package longestCommonSequence;

import utils.ArrayUtils;

public class LCSTopDownDP {

    public static Integer[][] lcsTopDown(char[] a, char[] b, Integer[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {

                if( i==0 || j==0)
                    t[i][j] = 0;
                else {
                    if( a[i-1]==b[j-1] ) {
                        t[i][j]= 1 + t[i-1][j-1];
                    } else {
                        int include = t[i-1][j];
                        int exclude = t[i][j-1];
                        t[i][j] = Math.max(include,exclude);
                    }
                }
            }
        }
        return t;
    }

    public static void main(String[] args) {

        char[] a = "abcdeaf".toCharArray();
        char[] b = "abcefar".toCharArray();

        int m = a.length;
        int n = b.length;

        Integer[][] t = new Integer[m+1][n+1];

        t=lcsTopDown(a,b,t);
        ArrayUtils.print(t);
    }
}
