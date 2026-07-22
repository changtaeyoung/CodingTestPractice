import java.util.*;

class Solution {
    
    static List<List<int[]>> graph;
    static int[] dist;
    
    static void ds (int idx) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{idx, 0});
        dist[idx] = 0;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            if (dist[cur[0]] < cur[1]) continue;
            
            for (int[] next : graph.get(cur[0])) {
                int nextCost = cur[1] + next[1];
                
                if (dist[next[0]] > nextCost) {
                    dist[next[0]] = nextCost;
                    pq.offer(new int[]{next[0], nextCost});
                }
            }
        }
    }
    
    // 들어오는 번호는 1base
    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for (int i = 0; i < road.length; i++) {
            graph.get(road[i][0]).add(new int[]{road[i][1], road[i][2]});
            graph.get(road[i][1]).add(new int[]{road[i][0], road[i][2]});
        }
        
        ds(1);
        
        int answer = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
}