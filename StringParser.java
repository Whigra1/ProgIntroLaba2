import java.util.ArrayList;

public class StringParser {
    public static ArrayList<String> parseString(String str){
        str = str.replaceAll("\\s","");
        char [] str_arr = str.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0;i < str_arr.length;i++){
            if (str_arr[i] == ';')
                continue;
           if (str_arr[i] == '-'){
                if (i > 0)
                    if((str_arr[i-1] == '*' || str_arr[i-1] == '(') &&
                            Character.isDigit(str_arr[i+1]))
                        res.add(str_arr[i] + "" + parseDigit(str_arr,i + 1));
                    else if(str_arr[i + 1] == '(')
                        res.add("!");
                    else
                        res.add(Character.toString(str_arr[i]));
                else if (i == 0)
                    if (Character.isDigit(str_arr[i + 1]))
                        res.add(str_arr[i] + "" + parseDigit(str_arr,i + 1));
                    else if(str_arr[i + 1] == '(')
                        res.add("!");
                else
                    res.add(Character.toString(str_arr[i]));
            }
          
            else if(Character.isDigit(str_arr[i]))
                res.add(parseDigit(str_arr,i));
            else
                res.add(Character.toString(str_arr[i]));
        }
        return res;
    }
    private static String parseDigit(char [] arr, int index){
        int temp = index;
        String num = "";
        while (Character.isDigit(arr[temp])) {
            num += arr[temp];
            arr[temp] = ';';
            temp++;
            if (temp >= arr.length)
                break;
        }
        return num;
    }
    
    public static boolean isDigit(String s){
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
