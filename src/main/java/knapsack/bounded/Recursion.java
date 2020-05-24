package knapsack.bounded;

import java.util.Random;

public class Recursion {

    private static int getMax(int[] weight, int[] value, int W, int n) {
        if (n == 0 || W == 0 )
            return 0;
        if (weight[n-1] <= W) {
            int include = value[n - 1] + getMax(weight, value, W - weight[n - 1], n - 1);
            int exclude = getMax(weight, value, W, n - 1);
            return java.lang.Math.max(include, exclude);
        } else
            return getMax(weight, value, W, n - 1);
    }

    public static void main(String[] args) {
        int[] weight = new int[] {1,3,7};
        int[] value = new int[] {10, 20, 30};
        int W = 10;

//        Random random = new Random();
//        int[] value = random.ints(10000, 10, 100).toArray();
//        int[] weight = random.ints(10000, 10, 100).toArray();
//        int W = 100;

        int n = weight.length;

        System.out.println(getMax(weight, value, W, n));

    }
}
