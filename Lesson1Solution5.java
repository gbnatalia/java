package my_java;

public class Lesson1Solution5 {
    public boolean isPalindrome(String s) {
        String new_s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = new_s.length() - 1; i >= 0; i--){
            if (Character.isLetterOrDigit(new_s.charAt(i)))
                sb.append(new_s.charAt(i));
        }

        int lastindex = sb.length() - 1;
        for (int i = 0; i < (sb.length() + 1) / 2; i++)
            if (sb.charAt(i) != sb.charAt(lastindex - i)){
                return false;
            }

       return true;
    }
}
