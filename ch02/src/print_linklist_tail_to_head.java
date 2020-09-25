public class print_linklist_tail_to_head
{
    public static void main(String[] args) {
        ListNode node1 = new ListNode(11);
        ListNode node2 = new ListNode(22);
        ListNode node3 = new ListNode(33);
        ListNode node4 = new ListNode(44);
        ListNode node5 = new ListNode(55);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        printList(node1);
    }

    public static void printList(ListNode head)
    {
        if (head == null)
            return;
        ListNode pre = head;
        ListNode cur = head.getNext();
        ListNode temp;
        while (cur != null)
        {
            temp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = temp;
        }
        head.setNext(null);
        while (pre != null)
        {
            System.out.println(pre.getData());
            pre = pre.getNext();
        }
    }
}

class ListNode
{
    private int data;
    private ListNode next;

    public ListNode(int data)
    {
        this.data = data;
        this.next = null;
    }

    public int getData()
    {
        return data;
    }

    public void setData(int data)
    {
        this.data = data;
    }

    public ListNode getNext()
    {
        return next;
    }

    public void setNext(ListNode next)
    {
        this.next = next;
    }
}