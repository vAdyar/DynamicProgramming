package knapsack.bounded;

import utils.ArrayUtils;

import java.util.Arrays;

//        Given a list of non-negative integers, a1, a2, ..., an, and a target, S.
//        Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
public class TargetSum {

    public static void main(String[] args) {
        int[] w = {1,1,2,3};
        int targetSum = 1;
        int n = (int)Arrays.stream(w).count();

        int W = ( Arrays.stream(w).sum() - targetSum ) / 2;

        Integer[][] t = new Integer[n+1][W+1];
        t = CountOfSubsetSum.countOfSubsetSum(w,t);

        ArrayUtils.print(t);
        System.out.println("Count of target sum: "+t[n][W]);
    }
}
