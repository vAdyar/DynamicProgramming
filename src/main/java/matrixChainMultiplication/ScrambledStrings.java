package matrixChainMultiplication;

//Scramble String using Recursion
//Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
public class ScrambledStrings {

//    Memorization to be added, can be added using a map.
    public static boolean solve(String s1, String s2) {

        if( s1.equals(s2) )
            return true;

        if( s1.length() <= 1 || s2.length() <= 1 || s1.length() != s2.length())
            return false;

        boolean flag = false;

        for (int k = 1; k < s1.length(); k++) {
            boolean swapTrue1 = solve(s1.substring(0,k), s2.substring(s1.length() - k));
            boolean swapTrue2 = solve(s1.substring(k), s2.substring(0,s1.length() - k));

            boolean swapFalse1 = solve(s1.substring(0,k), s2.substring(0,k));
            boolean swapFalse2 = solve(s1.substring(k), s2.substring(k));

            flag |= (swapTrue1 && swapTrue2) || (swapFalse1 && swapFalse2);
            if (flag)
                break;
        }

        return flag;
    }
    public static void main(String[] args) {

        String s1 = "great";
        String s2 = "eatgr";

//        int k= 2;
//        System.out.println(s1.substring(0,k));
//        System.out.println(s2.substring(s1.length() - k));
//        System.out.println(s1.substring(k));
//        System.out.println(s2.substring(0,s1.length() - k));

        System.out.println(solve(s1,s2));
    }
}
