
public class substructure_of_tree {

    public static void main(String[] args) {

        TreeNode tree1 = new TreeNode(333);
        TreeNode a = new TreeNode(111);
        TreeNode b = new TreeNode(222);
        TreeNode c = new TreeNode(444);
        TreeNode d = new TreeNode(555);
        tree1.setLeft(a);
        tree1.setRight(b);
        a.setLeft(c);
        a.setRight(d);

        TreeNode tree2 = new TreeNode(111);
        TreeNode e = new TreeNode(444);
        TreeNode f = new TreeNode(555);
        tree2.setLeft(e);
        tree2.setRight(f);

        boolean exist = hasSubstructure(tree1, tree2);
        if (exist)
            System.out.println("存在");
        else
            System.out.println("不存在");
    }

    public static boolean hasSubstructure(TreeNode tree1, TreeNode tree2){

        if (tree1 == null){
            if (tree2 == null)
                return true;
            else
                return false;
        }
        if (tree2 == null)
            return true;
        if (tree1.getValue() == tree2.getValue())
            return isSubstructure(tree1, tree2);
        return hasSubstructure(tree1.getLeft(), tree2) || hasSubstructure(tree1.getRight(), tree2);
    }

    public static boolean isSubstructure(TreeNode tree1, TreeNode tree2){

        if (tree1 == null){
            if (tree2 == null)
                return true;
            else
                return false;
        }
        if (tree2 == null)
            return true;
        if (tree1.getValue() == tree2.getValue())
            return isSubstructure(tree1.getLeft(), tree2.getLeft())
                    && isSubstructure(tree1.getRight(), tree2.getRight());
        return false;
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
