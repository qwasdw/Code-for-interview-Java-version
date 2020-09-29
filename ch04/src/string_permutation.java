import java.util.ArrayList;

public class string_permutation {

    public static void main(String[] args) {

        char[] string = {'a', 'b', 'c', 'd'};
        ArrayList<String> all = permutation(string);
        System.out.println(all);
    }

    public static ArrayList<String> permutation(char[] string){

        if (string == null || string.length == 0)
            return null;
        ArrayList<String> all = new ArrayList<>();
        permutation(string, 0, all);
        return all;
    }

    public static void permutation(char[] string, int index, ArrayList<String> all){

        if (index == string.length - 1){
            all.add(new String(string));
        }
        else {
            for (int i = index; i < string.length; i++){
                char temp = string[i];
                string[i] = string[index];
                string[index] = temp;
                permutation(string, index + 1, all);
                temp = string[i];
                string[i] = string[index];
                string[index] = temp;
            }
        }
    }
}
