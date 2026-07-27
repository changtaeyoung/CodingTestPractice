import java.util.*;

class Solution {
    
    static List<List<Integer>> graph;
    static boolean[] visited;
    
    static int ds (int idx, int eIdx) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{idx, 0});
        
        while (!q.isEmpty()) {
            int[] c = q.poll();
            
            if (c[0] == eIdx) return c[1];
            
            for (int next : graph.get(c[0])) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, c[1] + 1});
                }
            }
        }
        return -1;
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < roads.length; i++) {
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            visited = new boolean[n + 1];
            answer[i] = ds(sources[i], destination);
        }
        
        return answer;
    }
}