package knapsack.bounded;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Random;

public class RecursiveMemorization {

    private static int getMax(int[] weight, int[] value, int W, int n, Integer[][] t) {
        int ret = 0;
        System.out.println(">>>>>> for n:"+n + " W:"+W);
        ArrayUtils.print(t);
        if(t[n][W] != -1) {
            ret = t[n][W];
            System.out.println("Exiting for n:"+n + " W:"+W);
            ArrayUtils.print(t);;
            return t[n][W];
        }
        if(n ==0 || W ==0) {
            t[n][W] = 0;
            ret = 0;
            System.out.println("Exiting for n:"+n + " W:"+W);
            ArrayUtils.print(t);
            return 0;
        }
        if(weight[n-1] <= W) {
            int include = value[n-1] + getMax(weight, value, W-weight[n-1], n-1, t);
            int exclude = getMax(weight, value, W, n-1, t);
            ret = Math.max(include, exclude);
            t[n][W] = ret;
            System.out.println("Exiting for n:"+n + " W:"+W);
            ArrayUtils.print(t);
            return ret;
        } else {
            ret = getMax(weight, value, W, n-1, t);
            t[n][W] = ret;
            System.out.println("Exiting for n:"+n + " W:"+W);
            ArrayUtils.print(t);
            return ret;
        }

    }

    public static void main(String[] args) {
        Random random = new Random();

//        int[] weight = new int[] {1,3,7};
//        int[] value = new int[] {10, 20, 30};
//        int W = 11;
        int[] value = random.ints(10000, 10, 100).toArray();
		int[] weight = random.ints(10000, 10, 100).toArray();
        int W = 100;
        int n = weight.length;

        Integer[][] t = new Integer[n+1][W+1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                t[i][j] = -1;
            }
        }

//        Arrays.stream(weight).forEach(System.out::println);
        System.out.println(getMax(weight, value, W, n, t));

    }
}
