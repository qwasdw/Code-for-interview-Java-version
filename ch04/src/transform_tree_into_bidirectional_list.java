public class transform_tree_into_bidirectional_list {

    public static void main(String[] args) {

        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(4);

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);

        TreeNode a_ = convert(a);
        while (a_ != null){
            System.out.print("->" + a_.getValue());
            a_ = a_.getRight();
        }
    }

    public static TreeNode convert(TreeNode tree){
        if (tree == null)
            return null;
        TreeNode[] lastnode = new TreeNode[1];
        lastnode[0] = null;
        convertNode(tree, lastnode);
        while (tree.getLeft() != null)
            tree = tree.getLeft();
        return tree;
    }

    public static void convertNode(TreeNode node, TreeNode[] lastNode){

        if (node == null)
            return;
        convertNode(node.getLeft(), lastNode);
        node.setLeft(lastNode[0]);
        if (lastNode[0] != null)
            lastNode[0].setRight(node);
        lastNode[0] = node;
        convertNode(node.getRight(), lastNode);
    }
}
