import java.util.*;

class Solution {
    
    public int[] solution(String[] keyinput, int[] board) {
        // u, d, l, r
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int x = 0, y = 0;
        int dwx = -1 * board[1] / 2, dwy = -1 * board[0] / 2;
        int ux = board[1] / 2, uy = board[0] / 2;
        
        for (int i = 0; i < keyinput.length; i++) {
            
            int nx = 0, ny = 0;
            if (keyinput[i].equals("up")) {
                nx = x + dx[0];
                ny = y + dy[0];
                
                if (nx < dwx || nx > ux || ny < dwy || ny > uy) continue;
                
                x = nx;
                y = ny;
            }
            else if (keyinput[i].equals("down")) {
                nx = x + dx[1];
                ny = y + dy[1];
                
                if (nx < dwx || nx > ux || ny < dwy || ny > uy) continue;
                
                x = nx;
                y = ny;
            }
            else if (keyinput[i].equals("left")) {
                nx = x + dx[2];
                ny = y + dy[2];
                
                if (nx < dwx || nx > ux || ny < dwy || ny > uy) continue;
                
                x = nx;
                y = ny;
            }
            else if (keyinput[i].equals("right")) {
                nx = x + dx[3];
                ny = y + dy[3];
                
                if (nx < dwx || nx > ux || ny < dwy || ny > uy) continue;
                
                x = nx;
                y = ny;
            }
        }
        
        int[] answer = new int[]{y, x};
        return answer;
    }
}