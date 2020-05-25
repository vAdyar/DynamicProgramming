package longestCommonSequence;

import longestCommonSequence.LCSTopDownDP;
import utils.ArrayUtils;

public class SequencePatternMatching {

    public static void main(String[] args) {

        char[] c1 = "abcf".toCharArray();
        char[] c2 = "abcefar".toCharArray();

        int l1 = c1.length;
        int l2 = c2.length;

        Integer[][] t = new Integer[l1+1][l2+1];

        t= LCSTopDownDP.lcsTopDown(c1,c2,t);
        ArrayUtils.print(t);

        System.out.println("The string S1 is present as subsequence pattern in S2: "+(c1.length==t[l1][l2]));
    }
}
