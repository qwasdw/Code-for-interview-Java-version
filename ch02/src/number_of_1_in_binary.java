import jdk.jfr.Unsigned;

public class number_of_1_in_binary {

    public static void main(String[] args) {

        int n = -11;
        int numberOf1 = numberOf1(n);
        System.out.println("numberOf1-> Number of 1: " + numberOf1);
        numberOf1 = numberOf1Plus(n);
        System.out.println("numberOf1Plus-> Number of 1: " + numberOf1);
    }

    public static int numberOf1(int n){

        int count = 0;
        while (n != 0){
            if ((n & 1) == 1)
                count++;
            n = n>>>1;
        }
        return count;
    }

    public static int numberOf1Plus(int n){

        int count = 0;
        while (n != 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
