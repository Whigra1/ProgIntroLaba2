package laba2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str;
        if (args.length == 0)
            str = new Scanner(System.in).nextLine();
        else
            str = args[0];
        QueueArray<String> tokens = ShuntingYard.toPostfix(str);
        StackArray<String> s = new StackArray<>(tokens.getSize());
        while (!tokens.isEmpty()) {
            String elem = tokens.pop();
            if (StringParser.isDigit(elem))
                s.push(elem);
            else if(elem.equals("!"))
                s.push(String.valueOf(Double.parseDouble(s.pop()) * -1));
            else if(elem.equals("sin"))
                s.push(String.valueOf(Math.sin(Double.parseDouble(s.pop()))));
            else {
                double a = Double.parseDouble(s.pop());
                double b = Double.parseDouble(s.pop());
                s.push(String.valueOf(Operators.calculate(b, a, elem)));
            }
        }
        System.out.println(s.peek());
    }
}