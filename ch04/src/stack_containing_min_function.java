import java.util.Stack;

public class stack_containing_min_function {

    public static void main(String[] args) {

        minStack stack = new minStack();
        stack.push(111);
        stack.push(333);
        stack.push(22);
        stack.push(444);
        System.out.println(stack.top());
        System.out.println(stack.min());
        stack.pop();
        stack.pop();
        System.out.println(stack.min());
    }
}


class minStack{

    private Stack<Integer> stack;
    private Stack<Integer> supportStack;

    public minStack(){

        stack = new Stack<Integer>();
        supportStack = new Stack<Integer>();
    }

    public void push(int num){
        stack.push(num);
        if(supportStack.isEmpty())
            supportStack.push(num);
        else {
            int temp = supportStack.peek();
            if (num < temp)
                supportStack.push(num);
            else
                supportStack.push(temp);
        }
    }

    public void pop(){

        stack.pop();
        supportStack.pop();
    }

    public int top(){

        if (stack.isEmpty())
            throw new RuntimeException("栈空");
        return stack.peek();
    }

    public int min(){

        if (supportStack.isEmpty())
            throw new RuntimeException("栈空");
        return supportStack.peek();
    }
}