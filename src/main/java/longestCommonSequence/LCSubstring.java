package longestCommonSequence;

import utils.ArrayUtils;

public class LCSubstring {

    public static void main(String[] args) {
        char[] a = "abdcefg".toCharArray();
        char[] b = "abddgfg".toCharArray();

        int m = a.length;
        int n = b.length;

        Integer[][] t = new Integer[m+1][n+1];
        int max=0;

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if( i==0 || j==0 )
                    t[i][j] = 0;
                else {
                    if( a[i-1]==b[j-1] ) {
                        t[i][j] = 1 + t[i-1][j-1];
                        if( max<= t[i][j] )
                            max = t[i][j];
                    } else
                        t[i][j] = 0;
                }
            }
        }

        ArrayUtils.print(t);
        System.out.println("longest common substring: "+max);
    }
}
