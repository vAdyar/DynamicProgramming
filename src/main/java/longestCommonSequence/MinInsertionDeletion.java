package longestCommonSequence;

import utils.ArrayUtils;

//Minimum number of deletions and insertions to transform one string into another
//Given two strings ‘str1’ and ‘str2’ of size m and n respectively.
// The task is to remove/delete and insert minimum number of characters from/in str1 so as to transform it into str2.
// It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.
public class MinInsertionDeletion {

    public static void main(String[] args) {
        char[] str1 = "geeksforgeeks".toCharArray();
        char[] str2 = "geeks".toCharArray();

        int l1 = str1.length;
        int l2 = str2.length;

        Integer[][] t = new Integer[l1+1][l2+1];

        t=LCSTopDownDP.lcsTopDown(str1, str2, t);
        ArrayUtils.print(t);
        int LCSlength = t[l1][l2];
        int deletions = l1 - LCSlength;
        int insertion = l2 - LCSlength;

        System.out.println("Number of insertions: "+insertion);
        System.out.println("Number of deletions: "+deletions);
    }
}
