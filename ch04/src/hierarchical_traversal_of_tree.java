import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class hierarchical_traversal_of_tree {

    public static void main(String[] args) {

        TreeNode a = new TreeNode(111);
        TreeNode b = new TreeNode(222);
        TreeNode c = new TreeNode(333);
        TreeNode d = new TreeNode(444);
        TreeNode e = new TreeNode(555);
        TreeNode f = new TreeNode(666);

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        d.setLeft(f);
        hierarchicalTraversal(a);
        System.out.println();
        System.out.println("-------------");
        printByLevel(a);
        System.out.println("-------------");
        zigzagPrint(a);
    }

    public static void hierarchicalTraversal(TreeNode tree){

        if (tree == null)
            return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(tree);
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            System.out.print(node.getValue() + ", ");
            if (node.getLeft() != null)
                queue.add(node.getLeft());
            if (node.getRight() != null)
                queue.add(node.getRight());
        }
    }

    public static void printByLevel(TreeNode tree){

        if (tree == null)
            return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(tree);
        int nextLevel = 0;
        int toBePrinted = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            System.out.print(node.getValue() + ", ");
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
                nextLevel++;
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
                nextLevel++;
            }
            toBePrinted--;
            if (toBePrinted == 0){
                toBePrinted = nextLevel;
                nextLevel = 0;
                System.out.println();
            }

        }

    }

    public static void zigzagPrint(TreeNode tree){

        if (tree == null)
            return;
        Stack<TreeNode> oddStack = new Stack<TreeNode>();
        Stack<TreeNode> evenStack = new Stack<TreeNode>();
        oddStack.push(tree);
        while (!oddStack.isEmpty() || !evenStack.isEmpty()){
            if (!oddStack.isEmpty()){
                while (!oddStack.isEmpty()) {
                    TreeNode temp = oddStack.pop();
                    System.out.print(temp.getValue() + ", ");
                    if (temp.getLeft() != null)
                        evenStack.push(temp.getLeft());
                    if (temp.getRight() != null)
                        evenStack.push(temp.getRight());
                }
            }
            else {
                while (!evenStack.isEmpty()) {
                    TreeNode temp = evenStack.pop();
                    System.out.print(temp.getValue() + ", ");
                    if (temp.getRight() != null)
                        oddStack.push(temp.getRight());
                    if (temp.getLeft() != null)
                        oddStack.push(temp.getLeft());
                }
            }
            System.out.println();
        }
    }
}
