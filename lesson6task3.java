package lesson6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lesson6task3 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));

        s = "rat";
        t = "car";
        System.out.println(isAnagram(s, t));
    }


    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char c;
        int sch;
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            c = t.charAt(i);
            if (map.containsKey(c)) {
                sch = map.get(c);
                if (sch == 1) {
                    map.remove(c);
                } else {
                    map.put(c, sch - 1);
                }
            } else {
                return false;
            }
        }

        if (map.size() > 0)
            return false;

        return true;
    }
}
