package knapsack.bounded;

import utils.ArrayUtils;

import java.util.Arrays;

public class MinimumSubsetSumDifference {

    public static void main(String[] args) {
        int[] w = new int[] {1,3,7,4};
        int n = (int) Arrays.stream(w).count();

//        Find the difference of half the sum of array and then multiply by 2 to get the difference
        int W = Arrays.stream(w).sum() / 2;
        System.out.println("Value of W:" +W);

        Integer[][] t = new Integer[n+1][W+1];

        t = DynamicArray.maxSum(w,t);

        ArrayUtils.print(t);
        int diff = 2 * (W - t[n][W]);

        diff = Arrays.stream(w).sum() % 2 == 0 ? diff : ++diff;
        System.out.println("Minimum subset sum difference: "+diff);
    }
}
