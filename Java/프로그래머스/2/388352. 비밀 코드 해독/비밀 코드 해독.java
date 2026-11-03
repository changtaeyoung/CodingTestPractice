import java.util.*;
/*
    정수 5개 오름차순 비밀코드
    m번의 시도 가능
    포함되어있는 개수를 시스템 응답
    
    n 내에서 5개를 찾는 DFS를 진행하고, 그만큼 q와 비교해서 ans 값이 나오는지 확인
*/
class Solution {
    
    static int num, answer;
    static int[] aarr;
    static int[][] qarr;
    
    private boolean isValid (int[] cur) {
        
        for (int i = 0; i < qarr.length; i++) {
            int same = 0;
            
            for (int j = 0; j < qarr[i].length; j++) {
                for (int k = 0; k < cur.length; k++) {
                    if (cur[k] == qarr[i][j]) {
                        same++;
                        break; // 찾자마자 바로 다음꺼
                    }
                }
            }
            
            if (same != aarr[i]) return false;
        }
        
        return true;
    }
    
    private void dfs (int[] cur, int start, int depth) {
        
        if (depth == 5) {
            if (isValid(cur)) answer++;
            return;
        } 
        
        for (int i = start; i <= num; i++) {
            cur[depth] = i;       
            dfs(cur, i + 1, depth + 1);
        }
    }
    
    public int solution(int n, int[][] q, int[] ans) {
        num = n;
        aarr = ans;
        qarr = q;
        answer = 0;
        
        dfs (new int[5], 1, 0);
        
        return answer;
    }
}