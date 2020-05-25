package palindrome;

import longestCommonSequence.LCSTopDownDP;

//Minimum number of deletions to make a string palindrome
//Given a string of size ‘n’. The task is to remove or delete minimum number of characters from the string so that the resultant string is palindrome.
public class MinimumDeletionToPalindrome {

    public static void main(String[] args) {
        String str = "agbcba";

        StringBuilder sb = new StringBuilder(str);
        char[] c1 = sb.toString().toCharArray();
        char[] c2 = sb.reverse().toString().toCharArray();

        int m = c1.length;
        int n = c2.length;
        Integer[][] t = new Integer[m+1][n+1];

        t= LCSTopDownDP.lcsTopDown(c1,c2,t);
        System.out.println("Minimum number of deletions to make a string palindrome: "+(m - t[m][n]));
    }
}
