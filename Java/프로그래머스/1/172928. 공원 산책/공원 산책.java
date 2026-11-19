import java.util.*;

class Solution {
    // S, N, E, W
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] map;
    
    public int[] solution(String[] park, String[] routes) {
        map = new char[park.length][park[0].length()];
        
        int sx = 0, sy = 0;
        int[] answer = new int[2];
        
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                map[i][j] = park[i].charAt(j);
                
                if (map[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
            }
        }
        
        for (int i = 0; i < routes.length; i++) {
            String[] str = routes[i].split(" ");
            int dir = -1;
            int len = Integer.parseInt(str[1]);
            
            if (str[0].equals("E")) dir = 2;
            else if (str[0].equals("S")) dir = 0;
            else if (str[0].equals("W")) dir = 3;
            else dir = 1;
            
            // 이게 가능 하다면 그만큼 이동
            if (dir != -1 && isValid(sx, sy, dir, len)) {
                sx += (dx[dir] * len);
                sy += (dy[dir] * len);
            }
            
        }
        
        answer[0] = sx;
        answer[1] = sy;
        
        return answer;
    }
    
    private boolean isValid(int x, int y, int dir, int len) {
        
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        
        // map 내부에 있는가? 이동할 여력이 남아있는가?
        while(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && len > 0) {
            if (map[nx][ny] == 'X') { // 벽을 만나면 바로 false 반환.
                return false;
            }
            
            nx += dx[dir];
            ny += dy[dir];
            len--;
        }
        nx -= dx[dir];
        ny -= dy[dir];
        
        return len > 0 ? false : true; // 무사히 끝나면 len이 남아있는 것에 따라 true 반환
    }
}