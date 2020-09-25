public class replace_space
{
    public static void main(String[] args) {
        String string = "Process finished with exit code 0";
        String newString = replace(string);
        System.out.println(newString);
    }

    public static String replace(String string)
    {
        if (string.length() <= 0)
            return "";
        String newString = "";
        for (int i = 0; i < string.length(); i++)
        {
            if (string.charAt(i) == ' ')
            {
                newString += "%20";
            }
            else
                newString += string.charAt(i);
        }
        return newString;
    }
}
