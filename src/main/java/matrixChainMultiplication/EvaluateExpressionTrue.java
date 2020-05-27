package matrixChainMultiplication;

//Evaluate Expression To True-Boolean Parenthesization Recursion
//Given a boolean expression with following symbols.
//Symbols
//    'T' --- true
//    'F' --- false
//And following operators filled between symbols
//Operators
//    &   ---boolean AND
//    |   --- boolean OR
//    ^   --- boolean XOR
//Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
public class EvaluateExpressionTrue {

//    Not evaluating to right answer
    public static int solve(char[] c, int i, int j, char isTrue, Integer[][][] t) {
        int zAxis = (isTrue=='T')?1:0;
        if( t[i][j][zAxis] != -1)
            return t[i][j][zAxis];

        int ret = 0;

        if( i>j )
            return 0;

        if( i==j ) {
//            System.out.println("i:"+i);
//            System.out.println("j:"+j);
//            System.out.println("ret:"+((c[i] == isTrue)? 1 : 0));
//            System.out.println("Expected:" +isTrue);
//            System.out.println("Actual:" +c[i]);
//            System.out.println("-------------");
            return (c[i] == isTrue)? 1 : 0;
        }

        for (int k = i+1; k < j; k=k+2) {
            int leftTrue = -1;
            int leftFalse = -1;
            int rightTrue = -1;
            int rightFalse = -1;

            if ( t[i][k-1][1] != -1 )
                leftTrue = t[i][k-1][1];
            else {
               leftTrue= solve(c, i, k-1, 'T', t);
            }

            if ( t[i][k-1][0] != -1 )
                leftFalse = t[i][k-1][0];
            else
                leftFalse = solve(c, i, k-1, 'F', t);

            if ( t[k+1][j][1] != -1 )
                rightTrue = t[k+1][j][1];
            else
                rightTrue = solve(c, k+1, j, 'T', t);

            if ( t[k+1][j][0] != -1 )
                rightFalse = t[k+1][j][0];
            else
                rightFalse = solve(c, k+1, j, 'F', t);

//          An AND operation becomes 'true' only when both of the expressions are 'true'
            if (c[k] == '&') {
                if(isTrue == 'T')
                    ret += leftTrue*rightTrue;
                else if (isTrue == 'F')
                    ret += leftFalse * ( rightTrue + rightFalse ) + leftTrue * rightFalse;
            }
//          OR operation evaluates to true when either of the expression evaluates to true
            else if (c[k] == '|') {
                if(isTrue == 'F')
                    ret += leftFalse*rightFalse;
                else if (isTrue == 'F')
                    ret += leftTrue * ( rightTrue + rightFalse ) + leftFalse * rightTrue;
            }
//          XOR operation evaluates to true when both the expressions are different
            else if (c[k] == '^') {
                if(isTrue == 'T')
                    ret += leftTrue * rightFalse + leftFalse * rightTrue;
                else if (isTrue == 'F')
                    ret += leftTrue * rightTrue + leftFalse * rightFalse;
            }

        }

//        System.out.println("i:"+i);
//        System.out.println("j:"+j);
//        System.out.println("ret:"+ret);
//        System.out.println("Expected:" +isTrue);
//        System.out.println("Actual:" +c[i]);
//        System.out.println("-------------");
        return ret;
    }

    public static void main(String[] args) {

        char[] c = "T^F&T".toCharArray();

        Integer[][][] t = new Integer[c.length+1][c.length+1][2];

//        Face 1 is considered as 'T'
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                for (int k = 0; k < t[i][j].length; k++) {
                    t[i][j][k] = -1;
                }

            }
        }

        System.out.println(solve(c, 0, c.length-1, 'T', t));
    }
}