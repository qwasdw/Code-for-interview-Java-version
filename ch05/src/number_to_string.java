public class number_to_string {

    public static void main(String[] args) {

        int num = 11234211;
        int count = numberToString(num);
        System.out.println(count);
    }

    public static int numberToString(int num){

        if (num < 0)
            return 0;
        String string = "";
        string += num;
        int length = string.length();
        int[] counts = new int[length];
        int count = 0;
        for (int i = length - 1; i >= 0; i--){
            count = 0;
            if (i < length - 1)
                count = counts[i + 1];
            else
                count = 1;
            if (i < length - 1){
                int digit1 = string.charAt(i) - '0';
                int digit2 = string.charAt(i + 1) - '0';
                int converted = digit1 * 10 + digit2;
                if (converted >= 10 && converted <= 25){
                    if (i < length - 2)
                        count += counts[i + 2];
                    else
                        count += 1;
                }
            }
            counts[i] = count;
        }
        count = counts[0];
        return count;
    }
}
