import java.util.Comparator;
import java.util.PriorityQueue;

public class find_median {
    public static void main(String[] args) {

        insert(1);
        insert(3);
        insert(0);
        insert(-1);

        double mid = median();
        System.out.println(mid);
    }

    private static PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
    private static PriorityQueue<Integer> minQueue = new PriorityQueue<>();

    public static Double median(){

        if (((maxQueue.size() + minQueue.size()) & 1) == 1)
            return Double.valueOf(maxQueue.peek());
        return (double) ((maxQueue.peek() + minQueue.peek()) / 2.0);
    }

    public static void insert(int num){

        if (maxQueue.size() == 0 && minQueue.size() == 0)
            maxQueue.add(num);
        else if (((maxQueue.size() + minQueue.size()) & 1) == 1){
            if (num < maxQueue.peek()){
                minQueue.add(maxQueue.remove());
                maxQueue.add(num);
            }
            else
                minQueue.add(num);
        }
        else {
            if (num > minQueue.peek()){
                maxQueue.add(minQueue.remove());
                minQueue.add(num);
            }
            else
                maxQueue.add(num);
        }
    }
}
