import java.util.Stack;

public class two_stack_to_queue {

    public static void main(String[] args) {

        CQueue queue = new CQueue();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        queue.deleteHead();
        queue.appendTail(4);
        queue.deleteHead();
        queue.print();
    }
}

class CQueue{
    private Stack stack1 = new Stack();
    private Stack stack2 = new Stack();

    public CQueue(){

    }

    public  void appendTail(Object num){

        this.stack1.push(num);
    }

    public void deleteHead(){
        if (!stack2.isEmpty())
            stack2.pop();
        else {
            while (!stack1.isEmpty()){
                Object temp = stack1.pop();
                stack2.push(temp);
            }
            stack2.pop();
        }
    }

    public void print(){
        System.out.print("stack1: ");
        while (!stack1.isEmpty()){
            System.out.print(stack1.pop());
        }
        System.out.println();
        System.out.print("stack2: ");
        while (!stack2.isEmpty()){
            System.out.print(stack2.pop());
        }
    }
}