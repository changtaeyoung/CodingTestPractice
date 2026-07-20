import java.util.*;

class Solution {
    /*
        1차: wires안에 있는 연결을 1개를 빼고 그래프를 그려서 DFS를 해서 개수를 세면 되지 않나?
        + 2차원 배열 [wires크기][2] 해서 나뉜 값들 저장하고 각 애들을 뺀 것의 최소 값을 answer에 저장하기
        
    */
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int num;
    
    static void dfs (int idx) {
        visited[idx] = true;
        num++;
        
        for (int next : graph.get(idx)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
    
    public int solution(int n, int[][] wires) {
        
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) { // i는 연결 자른 번호
            
            graph = new ArrayList<>();
            for (int j = 0; j < n; j++ ){
                graph.add(new ArrayList<>());
            }
            visited = new boolean[n];
            num = 0;
            
            for (int j = 0; j < wires.length; j++) {
                if (i != j) {
                    graph.get(wires[j][0] - 1).add(wires[j][1] - 1);
                    graph.get(wires[j][1] - 1).add(wires[j][0] - 1);
                }
            }
            
            dfs(0);
            
            // num이 지금 1개의 전력망에 들어간 탑 개수. 나머지는 n - num
            // n - num - num 이니까.
            int diff = Math.abs(n - 2 * num);
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }
}