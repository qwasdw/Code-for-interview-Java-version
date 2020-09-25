import java.util.LinkedList;
import java.util.Queue;

public class two_queue_to_stack {

    public static void main(String[] args) {
        CStack stack = new CStack();
        stack.appendTail(111);
        stack.appendTail(222);
        stack.appendTail(333);
        stack.deleteTail();
        stack.appendTail(444);
        stack.deleteTail();
        stack.print();
    }
}

class CStack{

    private Queue<Integer> queue1 = new LinkedList();
    private Queue<Integer> queue2 = new LinkedList();

    public CStack() {

    }

    public void appendTail(int num){

        if (!queue1.isEmpty() || (queue1.isEmpty() && queue2.isEmpty()))
            queue1.add(num);
        else
            queue2.add(num);
    }

    public void deleteTail(){

        if (!queue1.isEmpty()){
            while (queue1.size() > 1) {
                int temp = queue1.remove();
                queue2.add(temp);
            }
            queue1.remove();
        }
        else if (!queue2.isEmpty()){
            while (queue2.size() > 1) {
                int temp = queue2.remove();
                queue1.add(temp);
            }
            queue2.remove();
        }
        else
            System.out.println("栈空");
    }

    public void print(){
        System.out.print("queue1: ");
        while (!queue1.isEmpty()){
            System.out.print(queue1.remove() + " ");
        }
        System.out.println();
        System.out.print("queue2: ");
        while (!queue2.isEmpty()){
            System.out.print(queue2.remove() + " ");
        }
    }

}