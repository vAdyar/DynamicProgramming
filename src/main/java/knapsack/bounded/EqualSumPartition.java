package knapsack.bounded;

import utils.ArrayUtils;

import java.util.Arrays;

//Find if the given array contains subsets such that their sum is equal using each element in either of the subset.
public class EqualSumPartition {

    public static void main(String[] args) {
        int[] w = new int[] {1,3,7,9,6,4};
        int n = (int) Arrays.stream(w).count();

//      Computing the required weight = total_sum / 2;
        int W = 0;
        W = Arrays.stream(w).sum() / 2;

        Boolean[][] t = new Boolean[n+1][W+1];

        t = SubsetSum.subsetSum(w,t);

        ArrayUtils.print(t);
        System.out.println(t[n][W]);
    }
}
