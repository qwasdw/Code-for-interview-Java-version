public class mirror_of_tree {

    public static void main(String[] args) {

        TreeNode a = new TreeNode(111);
        TreeNode b = new TreeNode(222);
        TreeNode c = new TreeNode(333);
        TreeNode d = new TreeNode(444);
        TreeNode e = new TreeNode(555);

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        c.setRight(e);

        print(a);

        mirror(a);

        print(a);

    }

    public static void mirror(TreeNode tree){
        if (tree == null)
            return;
        TreeNode temp = tree.getLeft();
        tree.setLeft(tree.getRight());
        tree.setRight(temp);
        mirror(tree.getLeft());
        mirror(tree.getRight());
    }

    private static class Trunk {
        Trunk prev;
        String str;

        private Trunk(Trunk prev, String str) {
            this.prev = prev;
            this.str = str;
        }
    }

    private static void showTrunks(Trunk p) {
        if (p == null)
            return;

        showTrunks(p.prev);

        System.out.print(p.str);
    }

    private static void traversalPrint(TreeNode root, Trunk prev, boolean isLeft) {
        if (root == null)
            return;

        String ROOT_PREV                    = "   ";
        String CHILD_PREV                   = "    ";

        String LEFT_CHILD_CURVED_EDGE       = ".---";
        String LEFT_CHILD_STRAIGHT_EDGE     = "   |";

        String RIGHT_CHILD_CURVED_EDGE      = "`---";
        String RIGHT_CHILD_STRAIGHT_EDGE    = "   |";


        String prev_str = CHILD_PREV;
        Trunk trunk = new Trunk(prev, prev_str);

        traversalPrint(root.getLeft(), trunk, true);

        if (prev == null)
            trunk.str = ROOT_PREV;
        else if (isLeft) {
            trunk.str = LEFT_CHILD_CURVED_EDGE;
            prev_str = LEFT_CHILD_STRAIGHT_EDGE;
        } else {
            trunk.str = RIGHT_CHILD_CURVED_EDGE;
            prev.str = prev_str;
        }

        showTrunks(trunk);

        System.out.println(root.getValue());

        if (prev != null)
            prev.str = prev_str;

        trunk.str = RIGHT_CHILD_STRAIGHT_EDGE;

        traversalPrint(root.getRight(), trunk, false);
    }

    public static void print(TreeNode root) {
        traversalPrint(root, null, false);
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
