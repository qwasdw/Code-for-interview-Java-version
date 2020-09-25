public class build_tree
{
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode tree = buildTree(pre, in);
        System.out.println("前序：");
        preOrder(tree);
        System.out.println();
        System.out.println("中序：");
        inOrder(tree);
        System.out.println();
    }

    public static TreeNode buildTree(int[] preOrder, int[] inOrder){

        TreeNode tree = build(preOrder, inOrder, 0, preOrder.length - 1,
                0, inOrder.length - 1);
        return tree;
    }

    public static TreeNode build(int[] preOrder, int[] inOrder, int startPre, int endPre, int startIn, int endIn){

        if (preOrder == null || inOrder == null || preOrder.length <= 0 || inOrder.length <= 0)
            return null;
        TreeNode root = new TreeNode(preOrder[startPre]);
        int rootIndex = -1;
        for (int i = startIn; i <= endIn; i++)
        {
            if (inOrder[i] == root.getValue()) {
                rootIndex = i;
                break;
            }
        }
        if (rootIndex == -1)
            return null;
        int leftLength = rootIndex - startIn;
        int rightLength = endIn - rootIndex;
        int leftEndPre = startPre + leftLength;
        if (leftLength > 0) {
            root.setLeft(build(preOrder, inOrder, startPre + 1, leftEndPre, startIn, rootIndex - 1));
        }
        if (rightLength > 0){
            root.setRight(build(preOrder, inOrder, leftEndPre + 1, endPre, rootIndex + 1, endIn));
        }
        return root;
    }

    public static void preOrder(TreeNode tree){

        if (tree == null)
            return;
        System.out.print(tree.getValue() + " ");
        if (tree.getLeft() != null)
            preOrder(tree.getLeft());
        if (tree.getRight() != null)
            preOrder(tree.getRight());
    }

    public static void inOrder(TreeNode tree){

        if (tree == null)
            return;
        if (tree.getLeft() != null)
            inOrder(tree.getLeft());
        System.out.print(tree.getValue() + " ");
        if (tree.getRight() != null)
            inOrder(tree.getRight());
    }

}

class TreeNode{

    private int value;
    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;

    public TreeNode(int value)
    {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value){

        this.value = value;
    }

    public TreeNode getLeft(){

        return left;
    }

    public void setLeft(TreeNode left){

        this.left = left;
    }

    public TreeNode getRight(){

        return right;
    }

    public void setRight(TreeNode right){
        this.right = right;
    }

    public TreeNode getParent(){

        return parent;
    }

    public void setParent(TreeNode parent){
        this.parent = parent;
    }
}