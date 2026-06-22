class Solution {
    static int[][] map;
    static int[][] dp;
    
    public int solution(int m, int n, int[][] puddles) {
        dp = new int[m][n];
        map = new int[m][n];
        
        for (int i = 0; i < puddles.length; i++) {
           map[puddles[i][0] - 1][puddles[i][1] - 1] = 1; 
        }
        dp[0][0] = 1;
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1 || (i == 0 && j == 0)) {
                    continue;
                }
                
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                }
                else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000007;
                }
            }
        }
        
        return dp[m - 1][n - 1];
    }
}