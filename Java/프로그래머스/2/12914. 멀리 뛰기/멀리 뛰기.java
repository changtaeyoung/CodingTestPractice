import java.util.*;

/*
    이 부분은 조합이 아니라 순열이네.
    1칸 또는 2칸만을 뛸 수 있어.
    그럼 현재 위치에서, 1칸만을 이용해서 뛰었을 때와 2칸만을 이용해서 뛰었을 때 2가지의 방식이 있는거지.
    그 두가지 방식을 합하면 될 거 같은데.
*/

class Solution {
    public long solution(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1; // 뛰지 않은 상태 1
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        
        return dp[n];
    }
}