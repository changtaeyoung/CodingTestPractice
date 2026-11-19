import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        
        int minW = Integer.MAX_VALUE, maxW = -1, minH = Integer.MAX_VALUE, maxH = -1;
        for (int i = 0; i < wallpaper.length; i++) {
            
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    if (minW > i) {
                        minW = i;
                    }
                    else if (maxW < i) {
                        maxW = i;
                    }
                    
                    if (minH > j) {
                        minH = j;
                    }
                    else if (maxH < j) {
                        maxH = j;
                    }
                }
            }
        }
        
        int[] ans = new int[4];
        if (maxW == -1 && maxH == -1) {
            ans[0] = minW;
            ans[1] = minH;
            ans[2] = minW + 1;
            ans[3] = minH + 1;
        }
        else {
            ans[0] = minW;
            ans[1] = minH;
            ans[2] = maxW + 1;
            ans[3] = maxH + 1;
        }
        
        return ans;
    }
}