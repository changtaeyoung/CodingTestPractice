import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int same = 0, diff = 0;
        char x = ' ';
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (same == 0 && diff == 0) {
                x = c;
            }
            
            if (x == c) same++;
            else diff++;
            
            if (same == diff) {
                answer++;
                same = 0;
                diff = 0;
            }
        }
        
        if (same != 0) answer++;
        
        return answer;
    }
}