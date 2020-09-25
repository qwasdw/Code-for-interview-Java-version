public class numeric_string {

    public static void main(String[] args) {

        String string = "1.1e1";
        boolean numeric = isNumeric(string);
        System.out.println(numeric);
    }

    public static boolean isNumeric(String string){
        if (string == null || string.length() <= 0)
            return false;
        int[] index = new int[1];
        index[0] = 0;
        boolean numeric = scanInteger(string, index);
        if (index[0] < string.length()) {
            if (string.charAt(index[0]) == '.') {
                index[0]++;
                numeric = scanUnsignedInteger(string, index) || numeric;
            }
        }
        if (index[0] < string.length()) {
            if (string.charAt(index[0]) == 'e' || string.charAt(index[0]) == 'E') {
                index[0]++;
                numeric = numeric && scanUnsignedInteger(string, index);
            }
        }
        return numeric && index[0] == string.length();
    }

    public static boolean scanInteger(String string, int[] index){

        if (string.charAt(index[0]) == '+' || string.charAt(index[0]) == '-')
            index[0]++;
        return scanUnsignedInteger(string, index);
    }

    public static boolean scanUnsignedInteger(String string, int[] index){

        int temp = index[0];
        while (index[0] < string.length() && string.charAt(index[0]) >= '0' && string.charAt(index[0]) <= '9')
            index[0]++;
        return index[0] > temp;
    }
}
