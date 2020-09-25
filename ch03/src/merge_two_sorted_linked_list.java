public class merge_two_sorted_linked_list {

    public static void main(String[] args) {

        ListNode list1 = new ListNode(111);
        ListNode b = new ListNode(222);
        ListNode c = new ListNode(333);
        ListNode d = new ListNode(444);
        ListNode e = new ListNode(555);
        list1.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        print(list1);
        System.out.println();

        ListNode list2 = new ListNode(222);
        ListNode f = new ListNode(333);
        ListNode g = new ListNode(444);
        ListNode h = new ListNode(555);
        ListNode i = new ListNode(666);
        list2.setNext(f);
        f.setNext(g);
        g.setNext(h);
        h.setNext(i);
        print(list2);
        System.out.println();

        ListNode head = merge(list1, list2);
        print(head);
    }

    public static ListNode merge(ListNode list1, ListNode list2){

        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode head = new ListNode(0);
        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode newNode = head;
        while (node1 != null && node2 != null){
            if (node1.getValue() <= node2.getValue()){
                newNode.setNext(node1);
                node1 = node1.getNext();
            }
            else {
                newNode.setNext(node2);
                node2 = node2.getNext();
            }
            newNode = newNode.getNext();
            newNode.setNext(null);
        }
        if (node1 != null)
            newNode.setNext(node1);
        if (node2 != null)
            newNode.setNext(node2);
        return head.getNext();
    }

    public static void print(ListNode head){

        ListNode node = head;
        while (node != null){
            System.out.print("->" + node.getValue());
            node = node.getNext();
        }
    }

}
