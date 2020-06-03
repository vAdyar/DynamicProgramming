package tree;

import utils.Node;
import utils.TreeUtils;

//Diameter of Tree
//Given a binary tree, you need to compute the length of the evaluate of the tree.
// The evaluate of a binary tree is the length of the longest path between any two nodes in a tree.
// This path may or may not pass through the root.

//Example:
//Given a binary tree
//          1
//         / \
//        2   3
//       / \
//      4   5
public class MaxDiameter {

    static int diameter = 0;

    public static int evaluate(Node node) {

        if( node == null )
            return 0;

        int left = evaluate(node.getLeft());
        int right = evaluate(node.getRight());

        int temp =  Math.max(left, right) + 1;
        int ans = Math.max(temp, left+right+1);
        diameter = Math.max(diameter, ans);

        return temp;
    }

    public static void main(String[] args) {

        Node root = TreeUtils.create();

        evaluate(root);
        System.out.println(diameter);


    }

}
