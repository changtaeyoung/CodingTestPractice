import java.util.*;

class Solution {
    
    /*
        최단거리니까 BFS일 거야.
        상하좌우 갈 수 있어
    */
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] visited;
    
    static void bfs (int sx, int sy, int[][] maps) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        visited[sx][sy] = 1;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (cur[0] == maps.length - 1 && cur[1] == maps[0].length - 1) {
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length) {
                    if (maps[nx][ny] == 1 && visited[nx][ny] == 0) {
                        visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new int[maps.length][maps[0].length];
        
        bfs(0, 0, maps);
        answer = visited[maps.length - 1][maps[0].length - 1];
        if (answer == 0) {
            return -1;
        }
        return answer;
    }
}