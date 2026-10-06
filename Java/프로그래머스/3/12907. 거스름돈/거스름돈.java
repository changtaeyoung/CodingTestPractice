import java.util.*;
/*
    거슬러줘야하는 금액이 있고...
    그렇다면 dp의 인자로 하는 값을 금액으로 계산하고, 그 배열에 들어가는 원소 값을 경우의수로 하는 것은 어떤가?
*/
class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        Arrays.sort(money);
        
        dp[0] = 1;
        for (int coin : money) {
            
            for (int i = coin ; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        
        return dp[n];
    }
}