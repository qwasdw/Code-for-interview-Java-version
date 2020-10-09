public class plus {

    public static void main(String[] args) {

        System.out.println(plus(1, 2));
    }

    public static int plus(int num1, int num2){

        int sum = 0;
        int carry = 0;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        while (num2 != 0);
            return num1;
    }
}
