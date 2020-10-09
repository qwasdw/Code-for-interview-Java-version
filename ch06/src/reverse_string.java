public class reverse_string {

    public static void main(String[] args) {

        String string = "I am a student.";
        System.out.println(reverseString(string));
        System.out.println(leftRotateString(string, 3));
    }

    public static String reverseString(String string){

        if (string == null || string.length() < 1)
            return "";
        char[] str = string.toCharArray();
        reverseWord(str, 0, str.length - 1);
        int start = 0;
        int end = 0;
        while (end < str.length){
            if (end > 0)
                start = end;
            while (end < str.length && str[end] != ' ')
                end++;
            reverseWord(str, start, end - 1);
            end++;
        }
        return new String(str);
    }

    public static void reverseWord(char[] word, int start, int end){

        while (start < end){
            char temp = word[start];
            word[start] =word[end];
            word[end] = temp;
            start++;
            end--;
        }
    }

    public static String leftRotateString(String string, int n){

        if (string == null || string.length() < n || n < 1)
            return "";
        char[] str = string.toCharArray();
        reverseWord(str, 0, n - 1);
        reverseWord(str, n, str.length - 1);
        reverseWord(str, 0, str.length - 1);
        return new String(str);
    }
}
