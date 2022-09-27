package my_java;

public class Lesson1Solution4 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int end = s.length(), start = end - 1;
        int lastspace = end;
        for (int i = s.length()-1; i >= 0; i--){
            if (s.charAt(i) == ' '){
                if (i + 1 != lastspace){
                    if (sb.length() > 0)  sb.append(" ");
                    sb.append(s.substring(++start, end));
                }
                end = i;
                start = end-1;
                lastspace = i;
            }
            else {
                start--;
            }
        }
        if (end > 0) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(s.substring(0, end));
        }

        return sb.toString();
    }
}
