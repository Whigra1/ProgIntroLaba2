package laba2;

public class Operators {
    public static double calculate(double a, double b, String operator){
        if (operator.equals("+"))
            return a + b;
        else if (operator.equals("-"))
            return a - b;
        else if (operator.equals("*"))
            return a * b;
        else if (operator.equals("/"))
            return a / b;
        else if (operator.equals("^"))
            return Math.pow(a,b);
        return 0;
    }

}
