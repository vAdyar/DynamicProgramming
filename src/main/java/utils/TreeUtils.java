package utils;

public class TreeUtils {

    public static Node create() {
        Node root = new Node(1);

        Node l1 = new Node(2);
        Node r1 = new Node(3);

        Node l2 = new Node(-4);
        Node r2 = new Node(-5);

        root.left = l1;
        root.right = r1;

        l1.left=l2;
        l1.right=r2;

        return root;
    }
}
