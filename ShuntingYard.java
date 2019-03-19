package laba2;
import java.util.*;
public class ShuntingYard {

    private enum Operator
    {
        ADD(1), SUBTRACT(2), MULTIPLY(3), DIVIDE(4), POW(5);
        final int precedence;
        Operator(int p) { precedence = p; }
    }

    private static Map<String, Operator> ops = new HashMap<String, Operator>() {{
        put("+", Operator.ADD);
        put("-", Operator.SUBTRACT);
        put("*", Operator.MULTIPLY);
        put("/", Operator.DIVIDE);
        put("^", Operator.POW);
    }};

    private static boolean isHigerPrec(String op, String sub)
    {
        return (ops.containsKey(sub) && ops.get(sub).precedence >= ops.get(op).precedence);
    }

    public static QueueArray toPostfix(String str){
        ArrayList<String> tokens = StringParser.parseString(str);
        StackArray<String> s = new StackArray<>(tokens.size());
        QueueArray<String> q = new QueueArray<>(tokens.size());
        for(String elem: tokens){
            if (StringParser.isDigit(elem))
                q.add(elem);
            else if(elem.equals("("))
                s.push(elem);
            else if(elem.equals(")")) {
                while (!s.peek().equals("("))
                    q.add(s.pop());
                s.pop();
            }

            else if (!StringParser.isDigit(elem)){
                while ( ! s.isEmpty() && isHigerPrec(elem, s.peek()))
                    q.add(s.pop());
                s.push(elem);
            }

        }

        int size = s.getSize();
        for (int i = 0; i < size;i++){
            q.add(s.pop());
        }
        return q;
    }

}
