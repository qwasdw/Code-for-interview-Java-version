public class Print_1_to_the_largest_n_digits {

    public static void main(String[] args) {

        int digit = 2;
        print(digit);
    }

    public static void print(int digit){

        char[] num = new char[digit];
        for (int i = 0;i < digit; i++)
            num[i] = '0';
        int carry = 0;
        while (!checkOverflow(num, digit)){
            for (int i = digit - 1; i >= 0; i--){
                if (i == (digit - 1)){
                    if (num[i] == '9') {
                        num[i] = '0';
                        carry = 1;
                    }
                    else {
                        num[i] += 1;
                        carry = 0;
                    }
                }
                else if (num[i] == '9' ){
                    if (carry == 1) {
                        num[i] = '0';
                        carry = 1;
                    }
                    else {
                        continue;
                    }
                }
                else {
                    if (carry == 1) {
                        num[i] += 1;
                        carry = 0;
                    }
                    else {
                        continue;
                    }
                }
            }
            print_num(num, digit);
        }
    }

    public static boolean checkOverflow(char[] num, int digit){

        for (int i = 0; i < digit; i++){
            if (num[i] != '9')
                return false;
        }
        return true;
    }

    public static void print_num(char[] num, int digit){
        int start = 0;
        while (num[start] == '0')
            start++;
        for (int i = start; i < digit; i++)
            System.out.print(num[i]);
        System.out.println();
    }
}
