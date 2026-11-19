import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int minRow = Integer.MAX_VALUE, minCol = Integer.MAX_VALUE;
        int maxRow = -1, maxCol = -1;

        for (int i = 0; i < wallpaper.length; i++) {
            String row = wallpaper[i];
            int left = row.indexOf('#');
            if (left == -1) continue;          // 파일 없는 행은 건너뜀

            int right = row.lastIndexOf('#');

            minRow = Math.min(minRow, i);
            maxRow = i;                        // i는 계속 커지니까 그냥 덮어쓰기
            minCol = Math.min(minCol, left);
            maxCol = Math.max(maxCol, right);
        }

        return new int[]{minRow, minCol, maxRow + 1, maxCol + 1};
    }
}