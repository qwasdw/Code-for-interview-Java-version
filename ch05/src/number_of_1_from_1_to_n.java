public class number_of_1_from_1_to_n {

    public static void main(String[] args) {

        int n = 100;
        int ones = numberOf1Between1AndN(n);
        System.out.println(ones);
        ones = numberOf1Between1AndN_(n);
        System.out.println(ones);
    }

    public static int numberOf1Between1AndN(int n){

        if (n < 0)
            return 0;
        String string = "";
        for (int i = 1; i <= n; i++)
            string += i;
        int ones = 0;
        for (int i = 0; i < string.length(); i++){
            if (string.charAt(i) == '1')
                ones++;
        }
        return ones;
    }

    public static int numberOf1Between1AndN_(int n){

        int ones = 0;
        for (long m = 1; m <= n; m *= 10){
            long a = n / m;
            long b = n % m;
            if (a % 10 == 0)
                ones += a / 10 * m;
            else if (a % 10 == 1)
                ones += (a / 10 * m) + (b + 1);
            else
                ones += (a / 10 + 1) * m;
        }
        return ones;
    }
}
