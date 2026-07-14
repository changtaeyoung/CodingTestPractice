import java.util.*;

class Solution {
    
    static boolean isFound;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    
    static void dfs(int x, int y, char[][] map, int cnt) {
        visited[x][y] = true;
        
        if (cnt != 0 && map[x][y] == 'P') {
            isFound = true;
            return;
        }
        
        if (cnt == 2) {
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {        
                if (!visited[nx][ny]) {
                    if (map[nx][ny] == 'P') {
                        isFound = true;
                        return;
                    }
                    if (map[nx][ny] == 'O') {
                        dfs(nx, ny, map, cnt + 1);
                        visited[nx][ny] = false;
                    }
                }
            }
        }
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int now = 0;
        
        for (String[] rooms : places) {
            char[][] room = new char[rooms.length][rooms[0].length()];
            visited = new boolean[rooms.length][rooms[0].length()];
            isFound = false;
            
            for (int i = 0; i < rooms.length; i++) {
                for (int j = 0; j < rooms[i].length(); j++) {
                    room[i][j] = rooms[i].charAt(j);
                }
            }
            
            for (int i = 0; i < room.length; i++) {
                for (int j = 0; j < room[i].length; j++) {
                    if (!visited[i][j] && room[i][j] == 'P') {
                        dfs (i, j, room, 0);
                    }
                }
            }
            
            answer[now] = isFound ? 0 : 1;
            now++;
        }
        
        return answer;
    }
}