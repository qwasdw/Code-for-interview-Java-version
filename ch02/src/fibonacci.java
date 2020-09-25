public class fibonacci {

    public static void main(String[] args) {
        int n = -1;
        System.out.println(fib(n));
    }

    public static int fib(int n){

        int fn_1 = 0;
        int fn_2 = 1;
        if (n <= 0)
            return fn_1;
        if (n == 1)
            return fn_2;
        int result = 0;
        while (n > 1){
            result = fn_1 + fn_2;
            n--;
            fn_1 = fn_2;
            fn_2 = result;
        }
        return result;
    }
}
