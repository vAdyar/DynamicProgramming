package tree;

import utils.Node;
import utils.TreeUtils;

//Given a non-empty binary tree, find the maximum path sum.
//
//For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
// The path must contain at least one node and does not need to go through the root.
public class PathSumOfNodes {

    private static int answer = 0 ;

    public static int solve(Node root) {

        if( root == null )
            return 0;

        int left = solve(root.getLeft());
        int right = solve(root.getRight());

        int temp1 = Math.max(left, right) + root.getValue();
        int temp = Math.max(root.getValue(), temp1);

        int ans = Math.max(temp, left+right+root.getValue());
        answer = Math.max(answer, ans);

        return temp;
    }

    public static void main(String[] args) {
        Node root = TreeUtils.create();

        solve(root);
        System.out.println(answer);

    }
}
