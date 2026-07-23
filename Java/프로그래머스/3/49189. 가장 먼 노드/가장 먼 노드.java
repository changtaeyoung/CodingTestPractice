import java.util.*;

class Solution {
    /*
        각 노드에서 최단 경로가 얼마나 이동해야하는지 계산한 뒤, 맞춰서 찾아내면 될 듯.
        근데 이건, 모든 간선이 동일하기 때문에 굳이 다익스트라 사용 안해도 될 거 같음.
        
        BFS 사용 가능.
    */
    
    static int[] visited;
    static List<List<Integer>> graph;
    
    static void bfs(int idx) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(idx);
        visited[idx] = 1;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int nxt : graph.get(cur)) {
                if (visited[nxt] == 0) {
                    visited[nxt] = visited[cur] + 1;
                    q.offer(nxt);
                }
            }
        }
    }
    
    public int solution(int n, int[][] edge) {
        visited = new int[edge.length];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        
        bfs(1);
        
        int maxVal = -1, maxNum = 0;
        for (int i = 0; i < visited.length; i++) {
            if (maxVal < visited[i]) {
                maxVal = visited[i];
                maxNum = 1;
            }
            else if (maxVal == visited[i]) {
                maxNum++;
            }
        }
        
        return maxNum;
    }
}