import java.util.*;

class Solution {
    static int[][] dist;
    static final int INF = 20000000; 
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        dist = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        
        for (int[] fare : fares) {
            int u = fare[0];
            int v = fare[1];
            int cost = fare[2];
            dist[u][v] = cost;
            dist[v][u] = cost;
        }
        
        // 플로이드-워셜 로직 (완벽함)
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        // 정답 도출 로직 (완벽함)
        int canAns = dist[s][a] + dist[s][b];
        
        for (int i = 1; i <= n; i++) {
            if (dist[s][i] != INF && dist[i][a] != INF && dist[i][b] != INF) {
                canAns = Math.min(canAns, dist[s][i] + dist[i][a] + dist[i][b]);
            }
        }
        
        return canAns;
    }
}