public class the_longest_substring_without_repeated_characters {

    public static void main(String[] args) {

        String string = "arabcacfr";
        int maxLength = substring(string);
        System.out.println(maxLength);
    }

    public static int substring(String string){

        int curLength = 0;
        int maxLength = 0;
        int[] position = new int[26];
        for (int i = 0; i < 26; i++)
            position[i] = -1;
        for (int i = 0; i < string.length(); i++){
            int prevIndex = position[string.charAt(i) - 'a'];
            if (prevIndex < 0 || i - prevIndex > curLength)
                curLength++;
            else {
                if (curLength > maxLength)
                    maxLength = curLength;
                curLength = i - prevIndex;
            }
            position[string.charAt(i) - 'a'] = i;
        }
        return maxLength;
    }
}
