package lesson6;

import java.util.*;

public class lesson6task1 {

    public static void main(String[] args) {
        String s = "IV";
        int result = romanToInt(s);
        System.out.printf("%s - %d", s, result);
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int n = s.length();
        int result = romanMap.get(s.charAt(n - 1));

        for (int i = n - 2; i >= 0; i--) {
            int cur_num = romanMap.get(s.charAt(i));
            if (cur_num >= romanMap.get(s.charAt(i + 1))) {
                result += cur_num;
            } else {
                result -= cur_num;
            }
        }
        return result;
    }
}


