package longestCommonSequence;

import utils.ArrayUtils;

public class PrintLCSubsequence {

    public static String printLCS(char[] a, char[] b, int i, int j, Integer[][] t) {
        String s = "";
        while( i!=0 && j!=0 ) {
            if( a[i-1]==b[j-1] ) {
                s = a[i-1] + s;
                i--; j--;
            } else {
                if (t[i-1][j] > t[i][j-1]) {
                    i--;
                }
                else {
                    j--;
                }
            }
        }
        System.out.println("String: "+s);
        return s;
    }

    public static void main(String[] args) {

        char[] a = "abcdeaf".toCharArray();
        char[] b = "abcefar".toCharArray();

        int m = a.length;
        int n = b.length;

        Integer[][] t = new Integer[m+1][n+1];

        t=LCSTopDownDP.lcsTopDown(a,b,t);
        ArrayUtils.print(t);
        printLCS(a,b,m,n,t);

    }
}
