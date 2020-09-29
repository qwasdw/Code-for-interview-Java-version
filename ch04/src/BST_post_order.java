public class BST_post_order {
    public static void main(String[] args) {

        int[] sequence = {7, 6, 3, 5};
        boolean result = isBSTPostOrder(sequence);
        if (result)
            System.out.println("是");
        else
            System.out.println("不是");
    }

    public static boolean isBSTPostOrder(int[] sequence){

        return isBSTPostOrder(sequence, 0, sequence.length);
    }

    public static boolean isBSTPostOrder(int[] sequence, int start, int length){

        if (sequence == null || sequence.length <= 0)
            return false;
        int root = sequence[length - 1];
        int i = 0;
        for (; i < length - 1; i++) {
            if (sequence[start + i] > root)
                break;
        }
        int j = i;
        for (; j < length - 1; j++){
            if (sequence[start + j] < root)
                return false;
        }
        boolean left = true;
        if (i > 0)
            left = isBSTPostOrder(sequence, 0, i);
        boolean right = true;
        if (i < length - 1)
            right = isBSTPostOrder(sequence, i, length - i - 1);
        return left && right;
    }

}
