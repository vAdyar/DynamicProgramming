package longestCommonSequence;

//Longest Common Subsequence Problem solution using recursion
//Given two sequences, find the length of longest subsequence present in both of them.
//A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.

public class LCSubsequenceRecursion {
//    Initialize with a base condition
//    Terminate with a choice diagram
//    Progressive call should be made of a smaller subset for recursion to terminate

    public static int lcs(char[] a, char[] b, int n, int m) {
        if( n==0 || m==0 )
            return 0;
        if( a[n-1]==b[m-1] )
            return 1 + lcs(a, b, n-1, m-1);
        else {
            int include = lcs(a, b, n-1, m);
            int exclude = lcs(a, b, n, m-1);
            return Math.max(include,exclude);
        }


    }

    public static void main(String[] args) {
        char[] a = "abcdeaf".toCharArray();
        char[] b ="abcefar".toCharArray();

        int n = a.length;
        int m = b.length;

        System.out.println(lcs(a,b,n,m));
    }
}
