public class reverse_linked_list {

    public static void main(String[] args) {

        ListNode a = new ListNode(111);
        ListNode b = new ListNode(222);
        ListNode c = new ListNode(333);
        ListNode d = new ListNode(444);
        ListNode e = new ListNode(555);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        print(a);
        ListNode newHead = reverse(a);
        System.out.println();
        print(newHead);
    }

    public static ListNode reverse(ListNode head){

        if (head == null)
            return null;
        ListNode newHead = new ListNode(0);
        newHead.setNext(head);
        ListNode node = head.getNext();
        head.setNext(null);
        while (node != null){
            ListNode temp = node.getNext();
            node.setNext(newHead.getNext());
            newHead.setNext(node);
            node = temp;
        }
        return newHead.getNext();
    }

    public static void print(ListNode head){

        ListNode node = head;
        while (node != null){
            System.out.print("->" + node.getValue());
            node = node.getNext();
        }
    }
}
