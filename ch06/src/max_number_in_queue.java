import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class max_number_in_queue {

    public static void main(String[] args) {

        int[] data = {2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> result = maxNumsInWindow(data, 3);
        System.out.println(result);

        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(10);
        maxQueue.push_back(-1);
        maxQueue.push_back(2);
        maxQueue.push_back(-2);
        maxQueue.push_back(3);
        System.out.println(maxQueue.max());
        maxQueue.pop_front();
        System.out.println(maxQueue.max());

    }

    public static ArrayList<Integer> maxNumsInWindow(int[] data, int window){

        ArrayList<Integer> result = new ArrayList<>();
        if (data == null || data.length < window || window < 1)
            return result;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < data.length; i++){
            while (!deque.isEmpty() && data[i] >= data[deque.peekLast()])
                deque.pollLast();
            if (!deque.isEmpty() && i - deque.peekFirst() >= window)
                deque.pollFirst();
            deque.offerLast(i);
            if (i + 1 >= window)
                result.add(data[deque.peekFirst()]);
        }
        return result;
    }

}

class MaxQueue{

    class InternalData{

        int number;
        int index;

        InternalData(int number, int index){
            this.number = number;
            this.index = index;
        }
    }
    private Deque<InternalData> maxQueue;
    private Deque<InternalData> deque;
    int currentIndex;

    MaxQueue(){
        maxQueue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    void push_back(int num){

        while (!maxQueue.isEmpty() && num >= maxQueue.peekLast().number)
            maxQueue.pollLast();
        InternalData internalData = new InternalData(num, currentIndex);
        deque.offerLast(internalData);
        maxQueue.offerLast(internalData);
        currentIndex++;
    }

    void pop_front(){

        if (maxQueue.isEmpty())
            throw new RuntimeException("队列为空");
        if (maxQueue.peekFirst().index == deque.peekFirst().index)
            maxQueue.pollFirst();
        deque.pollFirst();
    }

    int max(){
        if (maxQueue.isEmpty())
            throw new RuntimeException("队列为空");
        return maxQueue.peekFirst().number;
    }
}