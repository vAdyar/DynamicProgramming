package palindrome;

import longestCommonSequence.LCSTopDownDP;
import longestCommonSequence.PrintLCSubsequence;
import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Minimum number of insertions to make a string palindrome
//Given a string, find the minimum number of characters to be inserted to form Palindrome string out of given string
public class MinimumInsertionToPalindrome {

    public static void main(String[] args) {
        String str = "agbcba";

        StringBuilder sb = new StringBuilder(str);
        char[] c1 = sb.toString().toCharArray();
        char[] c2 = sb.reverse().toString().toCharArray();

        int l1 = c1.length;
        int l2 = c2.length;
        Integer[][] t = new Integer[l1+1][l2+1];

        t= LCSTopDownDP.lcsTopDown(c1,c2,t);

        ArrayUtils.print(t);
//        Same as number of deletion. As the missing pair can be inserted to a string to make it a pallindrome.
        System.out.println("Minimum number of insertion to make a string palindrome: "+(l1 - t[l1][l2]));

        String lcs = PrintLCSubsequence.printLCS(c1,c2,l1,l2,t);
        List list = new ArrayList();
        for (char c : c1) {
            list.add(c);
        }
        for (int i = 1; i < t.length-1; i++) {
            if( t[i+1][i+1] == t[i][i])
                list.add(l1-i, c1[i]);
        }
        System.out.print("Pallindromic string after insertion: ");list.stream().forEach(x -> System.out.print(x));
    }
}
