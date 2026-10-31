import java.util.*;
/*
    주어진 방향 이동 시 벗어나는지?
    장애물을 만나는지?
    0 베이스
    입력이 50, 50개라서 충분히 가능해보이는데.
    
    OSO
    OOO
    OXO
    OOO
*/
class Solution {
    
    // E, W, S, N
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] map;
    
    private boolean isValid (int x, int y, int dir, int len) {
        
        for (int i = 0; i < len; i++) {
            x += dx[dir];
            y += dy[dir];
            
            if (x < 0 || x >= map.length || y < 0 || y >= map[0].length 
                || map[x][y] == 'X')  {
                return false;
            }
        }
        
        return true;
    }
    
    public int[] solution(String[] park, String[] routes) {
        map = new char[park.length][park[0].length()]; 
    
        int x = 0, y = 0;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                map[i][j] = park[i].charAt(j);
                
                if (map[i][j] == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        
        for (int i = 0; i < routes.length; i++) {
            String[] str = routes[i].split(" ");
            int d = -1;
            
            if (str[0].equals("E")) {
                d = 0;
            }
            else if (str[0].equals("W")) {
                d = 1;
            }
            else if (str[0].equals("S")) {
                d = 2;
            }
            else if (str[0].equals("N")) {
                d = 3;
            }
            
            // true일 때만 이동 가능
            if (isValid(x, y, d, Integer.parseInt(str[1]))) {
                x += (dx[d] * Integer.parseInt(str[1]));
                y += (dy[d] * Integer.parseInt(str[1]));
            }
        }
        
        int[] answer = new int[2];
        answer[0] = x;
        answer[1] = y;
        
        return answer;
    }
}