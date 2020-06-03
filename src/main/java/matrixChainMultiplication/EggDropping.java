package matrixChainMultiplication;

import org.w3c.dom.Node;

//Egg Dropping using Recursion
//Problem statement: You are given N floor and K eggs. You have to minimize the number of times you have to drop the eggs to find the critical floor where critical floor means the floor beyond which eggs start to break. Assumptions of the problem:
//
//If egg breaks at ith floor then it also breaks at all greater floors.
//If egg does not break at ith floor then it does not break at all lower floors.
//Unbroken egg can be used again.
//Note: You have to find minimum trials required to find the critical floor not the critical floor.
public class EggDropping {

//    Meorization to be added.
    public static int solve(int floor, int eggs) {

        if( floor == 0 || floor == 1 || eggs == 0)
            return floor;

        int min = Integer.MAX_VALUE;

        for (int k = 1; k < floor; k++) {
            int temp = 0;
            int ifBroken = solve(k -1, eggs -1);
            int ifNotBroken = solve(floor - k, eggs);

//          Considering the worst case scenario
            temp = 1 + Math.max(ifBroken, ifNotBroken);

            min = Math.min(min, temp);
        }
        return min;
    }

    public static void main(String[] args) {

        int floor = 20;
        int eggs = 2;

        System.out.println(solve(floor, eggs));
    }
}
