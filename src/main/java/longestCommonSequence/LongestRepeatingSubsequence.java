package longestCommonSequence;

import utils.ArrayUtils;

// Longest Repeating Subsequence
//Given a string, print the longest repeating subsequence such that the two subsequence don’t have same string character at same position,
// i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.
public class LongestRepeatingSubsequence {

    public static Integer[][] lrs(char[] c1, char[] c2, Integer[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                if( i==0 || j==0 ) {
                    t[i][j] = 0;
                } else {
                    if ( i!=j && c1[i - 1] == c2[j - 1]) {
                        t[i][j] = 1 + t[i-1][j-1];
                    } else {
                        int inc1 = t[i][j-1];
                        int inc2 = t[i-1][j];
                        t[i][j] = Math.max(inc1, inc2);
                    }
                }
            }
        }
        return t;
    }

    public static void print(char[] c1, char[] c2, int l1, int l2, Integer[][] t) {
        String lrs = "";
        while( l1!=0 && l2!=0 ) {
            if( t[l1-1][l2-1] != t[l1][l2]) {
                lrs = c1[l1 - 1] + lrs;
            }
            l1--; l2--;
        }
        System.out.println("Longest Repeating Subsequence: "+lrs);
    }

    public static void main(String[] args) {

        String s = "aabebcdd";

        char[] c1 = s.toCharArray();
        char[] c2 = s.toCharArray();

        int l1 = c1.length;
        int l2 = c2.length;

        Integer[][] t = new Integer[l1+1][l2+1];
        t=lrs(c1,c2,t);

        ArrayUtils.print(t);
        print(c1,c2,l1,l2,t);
    }

}
