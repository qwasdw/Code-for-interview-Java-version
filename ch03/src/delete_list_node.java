public class delete_list_node {

    public static void main(String[] args) {

        ListNode a = new ListNode(222);
        ListNode b = new ListNode(222);
        ListNode c = new ListNode(333);
        ListNode d = new ListNode(444);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);

        deleteNode(a, c);
        print(a);
        System.out.println("..............");
        ListNode newHead = deleteDuplicateNode(a);
        print(newHead);

    }

    public static void deleteNode(ListNode head, ListNode target){

        if (head == null || target == null)
            return;
        if (target.getNext() != null){
            ListNode temp = target.getNext();
            target.setValue(temp.getValue());
            target.setNext(temp.getNext());
        }
        else if (head.getNext() == null){
            head = null;
            target = null;
        }
        else {
            ListNode temp = head;
            while (temp.getNext() != target){
                temp = temp.getNext();
            }
            temp.setNext(null);
            target = null;
        }
    }

    public static ListNode deleteDuplicateNode(ListNode head){

        if (head == null)
            return null;
        ListNode newHead = new ListNode(0);
        newHead.setNext(head);
        ListNode preNode = newHead;
        ListNode next;
        int value = head.getValue();
        while (preNode.getNext() != null){
            next = preNode.getNext();
            if (next.getValue() == value){
                while (next != null && next.getValue() == value){
                    next = next.getNext();
                }
                preNode.setNext(next);
            }
            else {
                value = next.getValue();
                preNode = next;
            }
        }
        return newHead.getNext();
    }

    public static void print(ListNode head){

        if (head == null){
            System.out.println("链表为空");
            return;
        }
        ListNode temp = head;
        while (temp != null){
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }
}

class ListNode{

    private int value;
    private ListNode next;

    public ListNode(int value){
        this.value = value;
        next = null;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public ListNode getNext(){
        return next;
    }

    public void setNext(ListNode next){
        this.next = next;
    }
}
