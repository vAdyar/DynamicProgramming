package palindrome;

import utils.ArrayUtils;

import java.util.Arrays;

//Palindrome Partitioning using Recursion
//Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome.
public class MCMPalindromePartition {

    public static int solve(String s, int i, int j, Integer[][] t) {
        int min = Integer.MAX_VALUE;

        if(t[i][j]!=-1)
            return t[i][j];

        if( i>=j || isPalindrome(s.substring(i,j)))
            return 0;

        for (int k = i; k < j; k++) {
            int left = -1;
            int right = -1;

            if (t[i][k] != -1)
                left = t[i][k];
            else
                left = solve(s, i, k, t);
            if (t[k+1][j] != -1)
                right = t[k+1][j];
            else
                right = solve(s, k+1, j, t);

            int temp = left + right + 1;
            if(temp<min)
                min = temp;
        }
        t[i][j] = min;
        return min;
    }

    private static boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    private static void print(Integer[][] t, String s) {
        String[] arr = new String[t[0][t.length-1]+1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "";
        }
        for (int i = 0; i < t.length-1; i++) {
            if(t[0][i] != t[0][i+1]) {
                index++;
                arr[index] = arr[index] + s.charAt(i);
            }
            else
                arr[index] = arr[index] + s.charAt(i);
        }
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void main(String[] args) {
        String s = "nitim";

        Integer[][] t = new Integer[s.length()+1][s.length()+1];
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = -1;
            }
        }

        System.out.println(solve(s,0, s.length(), t));
        ArrayUtils.print(t);
        print(t,s);
    }
}
