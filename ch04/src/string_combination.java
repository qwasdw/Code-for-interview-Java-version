import java.util.ArrayList;

public class string_combination {

    public static void main(String[] args) {

        char[] string = {'a', 'b', 'c', 'd'};
        ArrayList<ArrayList<Character>> all = combination(string);
        System.out.println(all);
    }

    public static ArrayList<ArrayList<Character>> combination(char[] string){

        if (string == null)
            return null;
        ArrayList<Character> combi = new ArrayList<>();
        ArrayList<ArrayList<Character>> all = new ArrayList<>();
        boolean[] visited = new boolean[string.length];
        for (int i = 1; i <= string.length; i++)
            combination(string, 0, i, visited, combi, all);
        return all;
    }

    public static void combination(char[] string, int start, int n, boolean[] visited,
                                                ArrayList<Character> combi, ArrayList<ArrayList<Character>> all){

        if (combi.size() == n)
            all.add(new ArrayList<>(combi));
        else {
            for (int i = start; i < string.length; i++){
                if (visited[i])
                    return;
                else
                    visited[i] = true;
                combi.add(string[i]);
                combination(string, start + 1, n, visited, combi, all);
                combi.remove(combi.size() - 1);
                visited[i] = false;
            }
        }
    }
}
