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

        char[] c1 = "abcdeaf".toCharArray();
        char[] c2 = "abcefar".toCharArray();

        int l1 = c1.length;
        int l2 = c2.length;

        Integer[][] t = new Integer[l1+1][l2+1];

        t=lcsTopDown(c1,c2,t);
        ArrayUtils.print(t);
    }
}
