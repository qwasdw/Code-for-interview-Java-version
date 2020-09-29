public class symmetric_tree {

    public static void main(String[] args) {

        TreeNode a = new TreeNode(111);
        TreeNode b = new TreeNode(222);
        TreeNode c = new TreeNode(222);
        TreeNode d = new TreeNode(333);
        TreeNode e = new TreeNode(333);

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        c.setRight(e);

        boolean symmetric = isSymmetric(a);
        if (symmetric)
            System.out.println("是对称树");
        else
            System.out.println("不是对称树");
    }

    public static boolean isSymmetric(TreeNode tree){

            return isSymmetric(tree, tree);
    }

    public static boolean isSymmetric(TreeNode tree1, TreeNode tree2){

        if (tree1 == null && tree2 == null)
            return true;
        if (tree1 == null || tree2 == null)
            return false;
        if (tree1.getValue() != tree2.getValue())
            return false;
        return isSymmetric(tree1.getLeft(), tree2.getRight())
                && isSymmetric(tree1.getRight(), tree2.getLeft());
    }
}
