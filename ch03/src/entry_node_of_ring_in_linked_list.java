public class entry_node_of_ring_in_linked_list {

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
        e.setNext(c);
        ListNode entryNode = entryNodeOfRing(a);
        try {
            System.out.println("环的入口节点为：" + entryNode.getValue());
        }
        catch (Exception ec){
            System.out.println("环不存在");
        }

    }

    public static ListNode entryNodeOfRing(ListNode head){

        if (head == null)
            return null;
        ListNode slowNode = head;
        ListNode fastNode = head.getNext();
        while (slowNode != fastNode){
            if (slowNode != null)
                slowNode = slowNode.getNext();
            if (fastNode != null)
                fastNode = fastNode.getNext();
            if (fastNode != null)
                fastNode = fastNode.getNext();
        }
        if (slowNode != null){
            int count = 1;
            fastNode = fastNode.getNext();
            while (slowNode != fastNode){
                count++;
                fastNode = fastNode.getNext();
            }
            slowNode = head;
            fastNode = head;
            while (count > 0){
                fastNode = fastNode.getNext();
                count--;
            }
            while (slowNode != fastNode){
                slowNode = slowNode.getNext();
                fastNode = fastNode.getNext();
            }
            return slowNode;
        }
        return null;
    }
}
