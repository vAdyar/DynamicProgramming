package matrixChainMultiplication;

import utils.ArrayUtils;

//Matrix Chain Multiplication using Recursion
// Given a sequence of matrices, find the most efficient way to multiply these matrices together.
// The problem is not actually to  perform the multiplications, but merely to decide in which order to perform the multiplications.
public class MCMRecursive {

    public static int solve(int[] arr, int i, int j, Integer[][] t) {
        int min = Integer.MAX_VALUE;

        if (t[i][j] != -1)
            return t[i][j];

        if( i>=j )
            return 0;

        for (int k = i; k < j; k++) {
            int left = -1;
            int right = -1;

            if (t[i][k] != -1)
                left = t[i][k];
            else
                left = solve(arr, i, k, t);
            if (t[k+1][j] != -1)
                right = t[k+1][j];
            else
                right = solve(arr, k+1, j, t);

            int temp = left + right + (arr[i-1] * arr[k] * arr[j]);
            if( temp<min )
                min = temp;
        }
        t[i][j] = min;
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        Integer[][] t = new Integer[arr.length+1][arr.length+1];

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = -1;
            }
        }

        System.out.println(solve(arr, 1, arr.length-1, t));
        ArrayUtils.print(t);
    }
}
