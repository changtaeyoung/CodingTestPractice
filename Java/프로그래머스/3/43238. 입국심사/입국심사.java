import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0, maxTime = -100, minTime = 0;
        
        for (int i = 0; i < times.length; i++) {
            if (maxTime < times[i]) {
                maxTime = times[i];
            }
        }
        maxTime *= n;
        
        while (minTime <= maxTime) {
            long t = (minTime + maxTime) / 2;
            long p = 0;
            
            for (int i = 0; i < times.length; i++) {
                p += (t / times[i]);
            }
            
            if (n <= p) {
                maxTime = t - 1;
                answer = t;
            }
            else {
                minTime = t + 1;
            }
        }
        
        return answer;
    }
}