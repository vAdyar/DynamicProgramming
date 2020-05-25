package longestCommonSequence;

import utils.ArrayUtils;

//Shortest Common Supersequence
//Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences.
public class ShortestCommonSuperSequence {

    public static void main(String[] args) {
        char[] a = "abcdeaf".toCharArray();
        char[] b = "abcefar".toCharArray();

        int m = a.length;
        int n = b.length;

        Integer[][] t = new Integer[m+1][n+1];

        t=LCSTopDownDP.lcsTopDown(a,b,t);
        ArrayUtils.print(t);

        System.out.println("Shortest common super-sequence: " +(m+n-t[m][n]));
    }
}
