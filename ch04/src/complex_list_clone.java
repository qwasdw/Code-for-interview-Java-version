public class complex_list_clone {

    public static void main(String[] args) {

        ComplexListNode a = new ComplexListNode(111);
        ComplexListNode b = new ComplexListNode(222);
        ComplexListNode c = new ComplexListNode(333);
        ComplexListNode d = new ComplexListNode(444);
        ComplexListNode e = new ComplexListNode(555);

        a.setNext(b);
        a.setSibling(c);
        b.setNext(c);
        b.setSibling(e);
        c.setNext(d);
        d.setNext(e);
        d.setSibling(b);

        print(a);
        System.out.println("--------------");
        ComplexListNode a_ = clone(a);
        print(a_);
    }

    public static ComplexListNode clone(ComplexListNode head){

        cloneNodes(head);
        connectSiblingNodes(head);
        return reconnectNodes(head);
    }

    public static void cloneNodes(ComplexListNode head){

        if (head == null)
            return;
        ComplexListNode node = head;
        while (node != null){
            ComplexListNode temp = new ComplexListNode(node.getValue());
            temp.setNext(node.getNext());
            node.setNext(temp);
            node = temp.getNext();
        }
    }

    public static void connectSiblingNodes(ComplexListNode head){

        if (head == null)
            return;
        ComplexListNode node = head;
        while (node != null){
            ComplexListNode temp = node.getNext();
            ComplexListNode sibling = node.getSibling();
            if (sibling != null)
                temp.setSibling(sibling.getNext());
            node = temp.getNext();
        }
    }

    public static ComplexListNode reconnectNodes(ComplexListNode head){

        if (head == null)
            return null;
        ComplexListNode newHead = head.getNext();
        ComplexListNode node = head;
        while (node != null){
            ComplexListNode temp = node.getNext();
            node.setNext(temp.getNext());
            node = node.getNext();
            if (node != null)
                temp.setNext(node.getNext());
        }
        return newHead;
    }

    public static void print(ComplexListNode head){

        if (head == null)
            return;
        ComplexListNode node = head;
        while (node != null){
            System.out.print(node.getValue() + "  ");
            if (node.getSibling() != null)
                System.out.print("sibling-> " + node.getSibling().getValue());
            System.out.println();
            node = node.getNext();
        }
    }
}

class ComplexListNode{

    private int value;
    private ComplexListNode next;
    private ComplexListNode sibling;

    public ComplexListNode(int value){
        this.value = value;
        this.next = null;
        this.sibling = null;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setNext(ComplexListNode next) {
        this.next = next;
    }

    public ComplexListNode getNext() {
        return next;
    }

    public void setSibling(ComplexListNode sibling) {
        this.sibling = sibling;
    }

    public ComplexListNode getSibling() {
        return sibling;
    }
}