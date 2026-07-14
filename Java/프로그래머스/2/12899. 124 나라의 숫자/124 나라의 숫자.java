import java.util.*;

class Solution {
    /*
        수학적 규칙이 뭘까? 라고 생각해 봤을 때
        3진법이랑 거의 비슷하다고 생각하면 돼. 0, 1, 2만 사용하잖아
        얘는 1, 2, 4만을 사용한다고 생각하면 됌.
        
        어떤 n을 나눴을 때
        
    */
    
    public String solution(int n) {
        String answer = "";
        StringBuilder ans = new StringBuilder();
        int[] useNum = {4, 1, 2}; // 나머지 0, 1, 2일 때
        
        while (n > 0) {
            ans.append(useNum[n % 3]);
            
            if (n % 3 == 0) {
                n = (n - 1) / 3;
            }
            else {
                n /= 3;
            }     
        }
        
        ans.reverse();
        answer = ans.toString();
        return answer;
    }
}