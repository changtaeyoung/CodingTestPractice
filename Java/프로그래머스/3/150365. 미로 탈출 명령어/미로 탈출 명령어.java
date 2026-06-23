import java.util.*;

class Solution {
    
    static int[] dx = {1, 0, 0, -1}; // d, l, r, u 순서
    static int[] dy = {0, -1, 1, 0};
    static int depth;
    static char[] str;
    
    static boolean dfs (int ex, int ey, int sx, int sy, int tx, int ty, int dist) {
        
        if (depth == dist) {
            return sx == tx && sy == ty;
        }
        
        int left = dist - depth;
        if (Math.abs(sx - tx) + Math.abs(sy - ty) > left) {
            return false;
        }
        if ((left - (Math.abs(sx - tx) + Math.abs(sy - ty))) % 2 != 0) {
            return false;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = sx + dx[i];
            int ny = sy + dy[i];
            
            if (nx >= 1 && nx <= ex && ny >= 1 && ny <= ey) {
                if (i == 0) {
                    str[depth] = 'd';
                }
                else if (i == 1) {
                    str[depth] = 'l';
                }
                else if (i == 2) {
                    str[depth] = 'r';
                }
                else {
                    str[depth] = 'u';
                }
                depth++;
                if (dfs(ex, ey, nx, ny, tx, ty, dist)) return true;
                depth--;
            }
        }
        return false;
    }
    
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        depth = 0;
        str = new char[k];
        
        if (Math.abs(x - r) + Math.abs(y - c) > k) {
            return "impossible";
        }
        
        if (dfs(n, m, x, y, r, c, k)) {
            return String.valueOf(str);
        }
        else {
            return "impossible";
        }
        
    }
}