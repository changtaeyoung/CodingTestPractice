import java.util.*;
/*
    결국 이 문제에서는 한발한발 몇점을 맞추는지 판단하는 것이 아닌
    몇 점에 어피치보다 많이 박아서 점수를 얻을 것이냐, 아니면 포기할 것이냐라는 2개의 분기점으로 나누는 것이 중요
    그것이 DFS를 탐색하는 방식.
*/
class Solution {
    int[] info;
    static int[] ryan;
    static int[] best;
    static int bestDiff;
    
    private void dfs (int idx, int left) {
        
        if (idx == 10) { // 0 ~ 10 점수 다 돌았다면
            ryan[idx] = left; // 남은 화살 싹 다 털기
            int diff = checkDiff();
            
            // diff는 일단 더 커야되고, 차이가 가장 큰지 확인해야하며, 같을 경우 작은 점수가 많은 값을 찾아야 함
            if (diff > 0 && (diff > bestDiff || (diff == bestDiff && checkLower(ryan, best)))) {
                bestDiff = diff;
                best = ryan.clone();
            }
            // ryan[10]? ryan[idx]? 결국 돌아가려면 idx가 맞는 판단인가? 어차피 10일때만 실행되니까 똑같은거 같기도
            ryan[10] = 0; 
            return;
        }
        
        // 어피치보다 많이 박아서 점수 먹을것임
        if (left >= info[idx] + 1) { 
            ryan[idx] = info[idx] + 1;
            dfs(idx + 1, left - ryan[idx]);
            ryan[idx] = 0;
        }
        // 이 점수는 포기
        dfs(idx + 1, left);
    }
    
    private int checkDiff() {
        int rsum = 0, asum = 0;
        
        for (int i = 0; i < ryan.length; i++) {
            if (ryan[i] == 0 && info[i] == 0) continue; // 둘다 0점이면 뭐 점수 못 얻으니까
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
        
        dfs (0, n); // 0번째가 10점이니까. 큰 순으로 탐색, n은 남은 화살 수
        
        return best == null ? new int[]{-1} : best;
    }
}