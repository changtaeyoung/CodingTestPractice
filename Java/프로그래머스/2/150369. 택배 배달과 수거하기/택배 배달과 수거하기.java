import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int d = n - 1, p = n - 1;
        
        while (true) {
            // 0인 부분은 뛰어 넘는 것이 좋다. 차피 쓸모 없는 구간이니까.
            while (d >= 0 && deliveries[d] == 0) d--;
            while (p >= 0 && pickups[p] == 0) p--;
            
            if (d < 0 && p < 0) break; // 반복 제거
            
            answer += (long) (Math.max(d, p) + 1) * 2;
            
            d = consume(deliveries, d, cap);
            p = consume(pickups, p, cap);
        }
        
        return answer;
    }
    
    private int consume (int[] arr, int idx, int cap) {
        int remain = cap;
        
        while (idx >= 0 && remain > 0) { // 인덱스 여유 있고, 남아있는 공간이 있으면 들어와
            if (arr[idx] <= remain) { // 남아있는 공간이 더 크면 더 담을 수 있고
                remain -= arr[idx];
                arr[idx] = 0;
                idx--;
            }
            else { // 더 못담어
                arr[idx] -= remain;
                remain = 0;
            }
        }
        
        return idx;
    }
}