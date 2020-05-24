package knapsack.bounded;

import utils.ArrayUtils;

import java.util.Arrays;

// The combination of subset taken once will contain all the elements of the array.
// sum(s1) - sum(s2) = diff
// sum(s1) + sum(s2) = sum(arr)
// sum(s1) = (sum(arr) + diff ) / 2         - count of subset sum
public class CountOfSubsetWithDifference {

    public static void main(String[] args) {
        int[] w = new int[] {1,3,1,2};
        int n = (int) Arrays.stream(w).count();

        int diff = 1;

        int W = ( Arrays.stream(w).sum() - diff ) / 2;

        Integer[][] t = new Integer[n+1][W+1];

        t = CountOfSubsetSum.countOfSubsetSum(w, t);

        ArrayUtils.print(t);
        System.out.println("Count of subset difference=1 is: "+t[n][W]);
    }
}
