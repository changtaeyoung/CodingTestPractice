import java.util.*;

class Solution {
    /*
        위에서 아래로 뻗어가는 방식 1
        아래에서 위로 올라가는 방식 2 가 있음.
        
        가장 정석인 방식은 방식 1
        
        2가 더 나은 이유는 1에서는 다 계산 후 가장 큰 수를 찾아야하지만, 2는 그러지 않아도 됨.
        
        이렇게 구현한다고 했을 경우 자신의 위치에서 (-1, 0), (-1, +1)한 위치의 값만 더해주면 됨.
    */
    public int solution(int[][] triangle) {
        
        // 1 사용
        int[][] dp = new int[triangle.length][triangle[triangle.length - 1].length];
        
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                }
                else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
                }
            }
        }
        
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < dp[dp.length - 1].length; i++) {
            if (answer < dp[dp.length - 1][i]) {
                answer = dp[dp.length - 1][i];
            }
        }
        
        return answer;
    }
}