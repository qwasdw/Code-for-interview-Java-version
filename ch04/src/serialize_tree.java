public class serialize_tree {

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

        String string = serialize(a);
        System.out.println(string);

        TreeNode tree = deserialize(string);
        mirror_of_tree.print(tree);
    }

    public static String serialize(TreeNode tree){
        String string = "";
        if (tree == null){
            string += "$,";
            return string;
        }
        string += tree.getValue();
        string += ",";
        string += serialize(tree.getLeft());
        string += serialize(tree.getRight());
        return string;
    }

    public static TreeNode deserialize(String string){

        if (string == null || string.length() <= 0)
            return null;
        String[] newString = string.split(",");
        int[] index = new int[1];
        index[0] = -1;
        return construct(newString, index);
    }

    public static TreeNode construct(String[] string, int[] index){

        index[0]++;
        if (string[index[0]].equals("$"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(string[index[0]]));
        node.setLeft(construct(string, index));
        node.setRight(construct(string, index));
        return node;
    }
}
