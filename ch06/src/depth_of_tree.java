public class depth_of_tree {

    public static void main(String[] args) {

        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(8);
        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setLeft(f);
        c.setRight(g);

        int result = depth(a);
        System.out.println(result);

        boolean result1 = isBalanced(a);
        System.out.println(result1);
    }

    public static int depth(TreeNode tree){

        if (tree == null)
            return 0;
        int[] result = new int[1];
        depth(tree, 1, result);
        return result[0];
    }

    public static void depth(TreeNode tree, int level, int[] result){

        if (tree == null)
            return;
        if (result[0] < level)
            result[0] = level;
        depth(tree.getLeft(), level + 1, result);
        depth(tree.getRight(), level + 1, result);
    }

    public static boolean isBalanced(TreeNode tree){

        if (tree == null)
            return true;
        boolean[] result = new boolean[1];
        result[0] = true;
        isBalanced(tree, result);
        return result[0];
    }
    public static int isBalanced(TreeNode tree, boolean[] result){

        if (tree == null)
            return 0;
        int left = isBalanced(tree.getLeft(), result);
        int right = isBalanced(tree.getRight(), result);
        int diff = left - right;
        if (diff < -1 || diff > 1)
            result[0] = false;
        return (left > right) ? (left + 1) : (right + 1);
    }
}
