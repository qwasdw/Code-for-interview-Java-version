public class number_at_index {

    public static void main(String[] args) {

        int index = 100;
        int num = digitAtIndex(index);
        System.out.println(num);
    }

    public static int digitAtIndex(int index){

        if (index < 0)
            throw new RuntimeException();
        int digits = 1;
        while (true){
            int numbers = countOfIntegers(digits);
            if (index < numbers * digits)
                return digitAtIndex(index, digits);
            index -= digits * numbers;
            digits++;
        }
    }

    public static int countOfIntegers(int digits){

        if (digits == 1)
            return 10;
        int count = (int) Math.pow(10, digits - 1);
        return 9 * count;
    }

    public static int digitAtIndex(int index, int digits){

        int number = beginNumber(digits) + index / digits;
        int indexFromRight = digits - index % digits;
        for (int i = 1; i < indexFromRight; i++)
            number /= 10;
        return number % 10;
    }

    public static int beginNumber(int digits){

        if (digits == 1)
            return 0;
        return (int) Math.pow(10, digits - 1);
    }
}
