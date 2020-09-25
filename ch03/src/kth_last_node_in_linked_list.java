public class kth_last_node_in_linked_list {

    public static void main(String[] args) {

        ListNode a = new ListNode(111);
        ListNode b = new ListNode(222);
        ListNode c = new ListNode(333);
        ListNode d = new ListNode(444);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        int k = 5;
        ListNode node = kth_last_node(a, k);
        try {
            System.out.println(node.getValue());
        }
        catch (Exception e){
            System.out.println("不存在倒数第" + k + "个节点");
        }
    }

    public static ListNode kth_last_node(ListNode head, int k){

        if (head == null || k <= 0)
            return null;
        ListNode preNode = head;
        ListNode node = head;
        int count = 0;
        while (node.getNext() != null && count < (k - 1)){
            count++;
            node = node.getNext();
        }
        if (count < (k - 1))
            return null;
        while (node.getNext() != null){
            preNode = preNode.getNext();
            node = node.getNext();
        }
        return preNode;
    }
}
