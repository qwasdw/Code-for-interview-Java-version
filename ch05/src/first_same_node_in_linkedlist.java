public class first_same_node_in_linkedlist {

    public static void main(String[] args) {

        ListNode list1 = new ListNode(111);
        ListNode a = new ListNode(333);
        ListNode b = new ListNode(444);
        ListNode c = new ListNode(555);

        ListNode list2 = new ListNode(222);

        list1.setNext(a);
        a.setNext(b);
        b.setNext(c);
        list2.setNext(b);

        ListNode node = firstSameNode(list1, list2);
        System.out.println(b);
        System.out.println(node);
        System.out.println(node.getData());

    }

    public static ListNode firstSameNode(ListNode list1, ListNode list2){

        if (list1 == null || list2 == null)
            return null;
        int length1 = 0;
        int length2 = 0;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != null){
            length1++;
            p1 = p1.getNext();
        }
        while (p2 != null){
            length2++;
            p2 = p2.getNext();
        }
        int len = length1 - length2;
        p1 = list1;
        p2 = list2;
        if (len > 0){
            while (len > 0){
                p1 = p1.getNext();
                len--;
            }
        }
        else{
            len = -len;
            while (len > 0){
                p2 = p2.getNext();
                len--;
            }
        }
        ListNode target = null;
        while (p1 != null){
            if (p1 == p2){
                target = p1;
                break;
            }
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        return target;
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

