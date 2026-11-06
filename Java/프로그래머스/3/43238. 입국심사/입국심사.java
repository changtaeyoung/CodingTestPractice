import java.util.*;
/*
    10억까지 처리 가능
    시간으로 이분탐색해야하는가 인원으로 이분탐색 해야하는가?
    시간으로 한다면 각각 시간을 주고 몇명까지 인원을 처리할 수 있는지 확인 가능. 따라서 시간으로 
*/
class Solution {
    public long solution(int n, int[] times) {
        long minT = 0, maxT = -1, answer = 0;
        
        for (int i = 0; i < times.length; i++) {
            if (maxT < times[i]) maxT = times[i];
        }
        maxT *= n;
        
        while (minT <= maxT) {
            long averT = (minT + maxT) / 2;
            long sumP = 0;
            
            // 현재 시간에서 몇 명을 심사할 수 있는지 체크
            for (int i = 0; i < times.length; i++) {
                sumP += (averT / times[i]);
            }
            
            // n명보다 작은 사람들을 심사할 수 있는 경우
            if (sumP < n) {
                minT = averT + 1;
            }
            else { // 크거나 같은 수 만큼 심사 가능하다면 여기선 최적을 찾는 것이 필요하니까. 시간 줄여야지
                answer = averT;
                maxT = averT - 1;
            }
        }
        return answer;
    }
}