public class match_pattern {

    public static void main(String[] args) {

        String string = "aba";
        String pattern = "a.*a";
        boolean exist = match(string, pattern);
        System.out.println(exist);
    }

    public static boolean match(String string, String pattern){

        return matchCore(string, 0, pattern, 0);
    }

    public static boolean matchCore(String string, int stringIndex, String pattern, int patternIndex){

        if (string.length() == 0 && pattern.length() == 0
                || stringIndex == string.length() && patternIndex == pattern.length())
            return true;
        if ((string.length() == 0 && pattern.length() != 0)
                || (string.length() != 0 && pattern.length() == 0))
            return false;
        if (stringIndex >= string.length()
                || patternIndex >= pattern.length())
            return false;
        if (patternIndex < (pattern.length() - 1) && pattern.charAt(patternIndex + 1) == '*'){
            if (string.charAt(stringIndex) == pattern.charAt(patternIndex)
                    || pattern.charAt(patternIndex) == '.'){
                return matchCore(string, stringIndex + 1, pattern, patternIndex)
                        || matchCore(string, stringIndex + 1, pattern, patternIndex + 2)
                        || matchCore(string, stringIndex, pattern, patternIndex + 2);
            }
            else
                return matchCore(string, stringIndex, pattern, patternIndex + 2);
        }
        if (string.charAt(stringIndex) == pattern.charAt(patternIndex)
                || pattern.charAt(patternIndex) == '.')
            return matchCore(string, stringIndex + 1, pattern, patternIndex + 1);
        return false;
    }
}
