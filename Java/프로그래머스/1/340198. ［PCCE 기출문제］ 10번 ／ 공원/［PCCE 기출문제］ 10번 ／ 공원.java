import java.util.*;

/*
    정사각형 모양 돗자리 -> 깔 수 있는 가장 큰 돗자리가 어떤 것인지 확인
    가지고 있는 애가 3개가 있을 때 가장 큰 것, 아무 돗자리도 깔지 못한다면 -1
    
    입력 = 50*50, 10개까지
    
    이건 그냥 mats 내림차순으로 만들고, park 하나하나 그냥 다 isValid를 적용하는게 가장 첫번째 든 생각
    isVaild를 bfs를 적용하면 더 좋은 알고리즘이 되지 않을까?
    
    bfs를 적용하면 가장 빠른 거리만을 선택하는 것이기 때문에 아님. 
    -> 그냥 DP를 이용해서 가장 큰 정사각형의 한 변의 길이를 구하고 그것보다 작거나 같은 값중 가장 큰 값을 구하는게 좋을 거 같음
    
    걍 너무 어렵게 생각하는 거 같음. 브루트 포스로도 충분이 가능해보이는데
*/
class Solution {
    
    private boolean isValid (int stx, int sty, int len, String[][] map) {
        
        boolean vPara = true;
        
        for (int i = stx; i < stx + len; i++) {
            for (int j = sty; j < sty + len; j++) {
                if (map[i][j].equals("-1")) continue;
                else {
                    vPara = false;
                    break;
                }
            }
            
            if (!vPara) break;
        }
        
        return vPara;
    }
    
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        int ans = 0;
        
        for (int i = mats.length - 1; i >= 0; i--) { // 내림차순 탐색
            int len = mats[i];
            boolean res = false;
            
            for (int j = 0; j <= park.length - len; j++) {
                for (int k = 0; k <= park[j].length - len; k++) {
                    res = isValid(j, k, len, park);
                    
                    // 가능하면 바로 len 리턴
                    if (res) return len;
                }
            }            
        }
        
        return -1;
    }
}