import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        // section에 들어가있는 값에 -1을 해야함. 1베이스여서.
        
        int idx = 0, ans = 0;
        
        for (int i = 0; i < section.length; i++) {
            
            if (idx > section[i]) continue;
            
            idx = section[i] + m;
            ans++;
        }
        
        return ans;
    }
}