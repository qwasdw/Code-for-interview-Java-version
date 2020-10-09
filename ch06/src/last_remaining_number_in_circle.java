public class last_remaining_number_in_circle {

    public static void main(String[] args) {

        System.out.println(lastRemaining(6, 3));
    }

    public static int lastRemaining(int n, int m){

        if (n < 1 || m < 1)
            return -1;
        int last = 0;
        for (int i = 2; i <= n; i++)
            last = (last + m) % i;
        return last;
    }
}
