import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dist = new int[n + 1][n + 1];

        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                if (i != j) dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for (int i = 0; i < fares.length; i++) {
            dist[fares[i][0]][fares[i][1]] = fares[i][2];
            dist[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (dist[j][i] != Integer.MAX_VALUE && dist[i][k] != Integer.MAX_VALUE) {
                        dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                    }
                }
            }
        }
        
        int ans = dist[s][a] + dist[s][b];
        for (int i = 1; i <= n; i++) {
            if (ans > dist[s][i] + dist[i][a] + dist[i][b]) {
                ans = dist[s][i] + dist[i][a] + dist[i][b];
            }
        }
        
        return ans;
    }
}