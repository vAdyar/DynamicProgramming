package longestCommonSequence;

import longestCommonSequence.LCSTopDownDP;
import utils.ArrayUtils;

//Given two strings X and Y, print the shortest string that has both X and Y as subsequences.
// If multiple shortest supersequence exists, print any one of them.
public class PrintSCS {

    private static Integer[][] lcs (char[] c1, char[] c2, Integer[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if( i==0 || j==0)
                    t[i][j] = 0;
                else {
                    if( c1[i-1] == c2[j-1] ){
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
        String scs = "";
        while( !(l1==0 && l2==0) ){
            if( ( l1>0 && l2>0) && c1[l1-1]==c2[l2-1] ) {
                scs = c1[l1-1] + scs;
                l1--; l2--;
            } else {
                if( ((l1!=0) && (l2==0)) || (t[l1-1][l2] > t[l1][l2-1]) ){
                    scs = c1[l1-1] + scs;
                    l1--;
                } else {
                    scs = c2[l2-1] +scs;
                    l2--;
                }
            }

        }
        System.out.println("SCS: "+scs);

    }

    public static void main(String[] args) {
        char[] c1 = "geek".toCharArray();
        char[] c2 = "eka".toCharArray();

        int l1=c1.length;
        int l2=c2.length;

        Integer[][] t = new Integer[l1+1][l2+1];
        t= LCSTopDownDP.lcsTopDown(c1,c2,t);
        ArrayUtils.print(t);

        print(c1,c2,l1,l2,t);
    }
}
