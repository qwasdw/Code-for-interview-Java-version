public class kth_node_in_tree {

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

        TreeNode node = kthNode(a, 3);
        System.out.println(node.getValue());
    }

    public static TreeNode kthNode(TreeNode tree, int k){

        if (tree == null || k == 0)
            return null;
        int[] m = new int[1];
        return kthNode(tree, k, m);
    }

    public static TreeNode kthNode(TreeNode tree, int k, int[] m){

        TreeNode target = null;
        if (tree.getLeft() != null)
            target = kthNode(tree.getLeft(), k, m);
        m[0]++;
        if (m[0] == k)
            target = tree;
        if (target == null && tree.getRight() != null)
            target = kthNode(tree.getRight(), k, m);
        return target;
    }

}


class TreeNode{

    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public TreeNode getLeft(){
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}