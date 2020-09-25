public class get_next_node_in_tree
{
    public static void main(String[] args) {
        TreeNode a = new TreeNode(111);
        TreeNode b = new TreeNode(222);
        TreeNode c = new TreeNode(333);
        TreeNode d = new TreeNode(444);
        TreeNode e = new TreeNode(555);
        TreeNode f = new TreeNode(666);
        TreeNode g = new TreeNode(777);

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        b.setParent(a);
        c.setLeft(f);
        c.setRight(g);
        c.setParent(a);
        d.setParent(b);
        e.setParent(b);
        f.setParent(c);
        g.setParent(c);
        TreeNode next = getNextNode(d);
        if (next != null)
            System.out.println("下一节点为：" + next.getValue());
        else
            System.out.println("不存在下一节点");
    }

    public static TreeNode getNextNode(TreeNode tree){

        if (tree == null)
            return null;
        if (tree.getRight() != null){
            TreeNode temp = tree.getRight();
            while (temp.getLeft() != null)
                temp = temp.getLeft();
            return temp;
        }
        TreeNode parent = tree.getParent();
        if (parent == null)
            return null;
        TreeNode temp = tree;
        while (parent != null){
            if (parent.getLeft() == temp)
                return parent;
            if (parent.getParent() == null)
                return null;
            temp = parent;
            parent = parent.getParent();
        }
        return null;
    }
}
