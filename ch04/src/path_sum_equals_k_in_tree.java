import java.util.ArrayList;

public class path_sum_equals_k_in_tree {

    public static void main(String[] args) {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);

        findPath(a, 7);
    }

    public static void findPath(TreeNode tree, int k){

        if (tree == null)
            return;
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<ArrayList<Integer>> allPath = new ArrayList<>();
        findPath(tree, k, path, allPath);
        System.out.println(allPath);
    }

    public static void findPath(TreeNode tree, int k, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> allPath){

        if (tree == null)
            return;
        path.add(tree.getValue());
        k -= tree.getValue();
        if (tree.getLeft() == null && tree.getRight() == null && k == 0)
            allPath.add(new ArrayList<>(path));
        findPath(tree.getLeft(), k, path, allPath);
        findPath(tree.getRight(), k, path, allPath);
        path.remove(path.size() - 1);
        k += tree.getValue();
    }
}
