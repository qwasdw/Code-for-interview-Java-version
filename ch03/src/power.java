public class power {

    public static void main(String[] args) {

        double num = -11;
        int exponent = 6;
        double power = pow(num, exponent);
        System.out.println("pow-> " + num + "的" + exponent + "次方为：" + power);
        power = pow1(num, exponent);
        System.out.println("pow1-> " + num + "的" + exponent + "次方为：" + power);
    }

    public static double pow(double num, int exponent){

        if (num == 0)
            return 0;
        if (exponent == 0)
            return 1;
        int flag = 1;
        double result = 1;
        if (exponent < 0) {
            flag = -1;
            exponent = -exponent;
        }
        while (exponent > 0){
            result *= num;
            exponent--;
        }
        return flag > 0 ? result : (1 / result);
    }

    public static double pow1(double num, int exponent){

        if (num == 0)
            return 0;
        if (exponent == 0)
            return 1;
        int flag = 1;
        double result = 1;
        if (exponent < 0) {
            flag = -1;
            exponent = -exponent;
        }
        while (exponent > 0){
            if ((exponent & 1) == 1)
                result *= num;
            num *= num;
            exponent = exponent >> 1;
        }
        return flag > 0 ? result : (1 / result);
    }
}
