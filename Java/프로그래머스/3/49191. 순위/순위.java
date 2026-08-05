class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] fight = new boolean[n + 1][n + 1];
        
        for (int i = 0; i < results.length; i++) {
            fight[results[i][0]][results[i][1]] = true;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    fight[s][e] = fight[s][e] || (fight[s][i] && fight[i][e]);
                }
            }
        }
        
        int answer = 0;
        for (int s = 1; s <= n; s++) {
            int cnt = 0;
            for (int e = 1; e <= n; e++) {
                if (s != e && (fight[s][e] || fight[e][s])) {
                    cnt++;
                }
            }
            
            if (cnt == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
}