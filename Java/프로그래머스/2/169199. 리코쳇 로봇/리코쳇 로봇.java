import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    static int bfs (int sx, int sy, String[] map) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (map[cur[0]].charAt(cur[1]) == 'G') {
                return cur[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                while (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length()) {
                    if (map[nx].charAt(ny) == 'D') {
                        break;
                    }
                    nx += dx[i];
                    ny += dy[i];
                }
                
                nx -= dx[i];
                ny -= dy[i];
                
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cur[2] + 1});
                }
            }
        }
        return -1;
    }
    
    public int solution(String[] board) {
        visited = new boolean[board.length][board[0].length()];
        int answer = 0;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    answer = bfs(i, j, board);
                }
            }
        }
         return answer;
    }
}