import java.util.HashMap;

public class first_not_repeating_char {

    public static void main(String[] args) {

        String string = "aaccdeff";
        char result = firstNotRepeatingChar(string);
        System.out.println(result);
    }

    public static char firstNotRepeatingChar(String string){

        if (string == null)
            return '\0';
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < string.length(); i++){
            if (!hashMap.containsKey(string.charAt(i)))
                hashMap.put(string.charAt(i), 1);
            else
                hashMap.put(string.charAt(i), hashMap.get(string.charAt(i)) + 1);
        }
        for (char key : hashMap.keySet()){
            if (hashMap.get(key) == 1)
                return key;
        }
        return '\0';
    }
}
