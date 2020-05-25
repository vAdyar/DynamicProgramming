package palindrome;

import longestCommonSequence.LCSTopDownDP;

//Longest Palindromic Subsequence
//Given a sequence, find the length of the longest palindromic subsequence in it.
public class LongestPalindromicSequence {

    public static void main(String[] args) {
        String str = "agbcba";

        StringBuilder sb = new StringBuilder(str);
        char[] c1 = sb.toString().toCharArray();
        char[] c2 = sb.reverse().toString().toCharArray();

        int m = c1.length;
        int n = c2.length;
        Integer[][] t = new Integer[m+1][n+1];

        t= LCSTopDownDP.lcsTopDown(c1,c2,t);
        System.out.println("Longest Palindromic Subsequence: "+t[m][n]);
    }
}