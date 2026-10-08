import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];
        
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = num;
                num++;
            }
        }
        
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int sx = queries[i][0] - 1;
            int sy = queries[i][1] - 1;
            int ex = queries[i][2] - 1;
            int ey = queries[i][3] - 1;
            
            List<Integer> list = new ArrayList<>();
            
            for (int j = sy; j < ey; j++) {
                list.add(map[sx][j]);
            }
            
            for (int j = sx; j < ex; j++) {
                list.add(map[j][ey]);
            }
            
            for (int j = ey; j > sy; j--) {
                list.add(map[ex][j]);
            }
            
            for (int j = ex; j > sx; j--) {
                list.add(map[j][sy]);
            }
            
            Collections.rotate(list, 1);
            int idx = 0;
            for (int j = sy; j < ey; j++) {
                map[sx][j] = list.get(idx);
                idx++;
            }
            
            for (int j = sx; j < ex; j++) {
                map[j][ey] = list.get(idx);
                idx++;
            }
            
            for (int j = ey; j > sy; j--) {
                map[ex][j] = list.get(idx);
                idx++;
            }
            
            for (int j = ex; j > sx; j--) {
                map[j][sy] = list.get(idx);
                idx++;
            }
            
            Collections.sort(list);
            ans[i] = list.get(0);
        }
        
        return ans;
    }
}