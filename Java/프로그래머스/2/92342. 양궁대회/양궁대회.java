import java.util.*;

class Solution {
    int[] info;
    static int[] ryan;
    static int[] best;
    static int bestDiff;
    
    private void dfs (int idx, int left) {
        
        if (idx == 10) {
            ryan[idx] = left; // 남은 화살 모조리 몰빵
            int diff = checkDiff();
            
            if (diff > 0 && (diff > bestDiff || (diff == bestDiff && checkLower(ryan, best)))) {
                bestDiff = diff;
                best = ryan.clone();
            }
            
            ryan[10] = 0;   
            return;
        }
        
        if (left >= info[idx] + 1) {
            ryan[idx] = info[idx] + 1; // 어피치보다 1발 많게 쏴서 점수를 먹는 경우의 수
            dfs(idx + 1, left - ryan[idx]);
            ryan[idx] = 0;
        }
        dfs(idx + 1, left); // 그냥 아예 안 쏴서 점수 포기 경우의 수
    }
    
    private int checkDiff() {
        int rsum = 0, asum = 0;
        for (int i = 0; i < ryan.length; i++) {
            if (ryan[i] == 0 && info[i] == 0) continue; // 둘 다 점수 못받으니까
            else if (ryan[i] > info[i]) rsum += (10 - i);
            else asum += (10 - i);
        }
        
        return rsum - asum;
    }
    
    private boolean checkLower(int[] r, int[] b) {
        for (int i = r.length - 1; i >= 0; i--) {
            if (r[i] != b[i]) return r[i] > b[i];
        }
        return false;
    }
    
    
    public int[] solution(int n, int[] info) {
        this.info = info;
        ryan = new int[11];
        bestDiff = 0;
        
        dfs (0, n);
        
        return best == null ? new int[]{-1} : best;
    }
}