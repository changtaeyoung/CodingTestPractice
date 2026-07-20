import java.util.*;

class Solution {
    /*
        4, 3, 2, 1, 2, 3, 4
        
        작은 애들부터 시작해서, 1:1, 1:2, 2:3, 3:4 인 위치에 모두 가능
        
        반복문 1개로 가능한 방법이 있는가?에 대해서 고민해봐야할듯.
        
    */
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
                
        for (int i = weights.length - 1; i >= 0; i--) {
    
            for (int j = 0; j < i; j++) {
                
                if (weights[i] == weights[j]) {
                    answer++;
                }
                
                if (weights[i] == 2 * weights[j]) {
                    answer++;
                }
                
                if (2 * weights[i] == 3 * weights[j]) {
                    answer++;
                }
                
                if (3 * weights[i] == 4 * weights[j]) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}