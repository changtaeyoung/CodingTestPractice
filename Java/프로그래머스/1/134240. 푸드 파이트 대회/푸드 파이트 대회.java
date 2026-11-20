import java.util.*;

class Solution {
    public String solution(int[] food) {
        String left = "";
        
        for (int i = 1; i < food.length; i++) {
            
            if (food[i] % 2 == 0) { // 짝수일 때
                for (int j = 0; j < food[i] / 2; j++) {
                    left += i;
                }
            }
            else { // 홀수일 때
                for (int j = 0; j < (food[i] - 1) / 2; j++) {
                    left += i;
                }
            }
        }
        
        String ans = left + "0";
        
        for (int i = left.length() - 1; i >= 0; i--) {
            ans += left.charAt(i);
        }
        
        
        return ans;
    }
}