import java.util.*;

class Solution {
    public long solution(int n, int[] times) {        
        long minT = 1, maxT = 0;
        for (int i = 0; i < times.length; i++) {
            if (maxT < times[i]) {
                maxT = times[i];
            }
        }
        maxT *= n;
        
        long answer = 0;
        while (minT <= maxT) {
            long averT = (minT + maxT) / 2;
            long totalP = 0;
            
            for (int i = 0; i < times.length; i++) {
                totalP += averT / times[i];
            }
            
            if (totalP >= n) {
                answer = averT;
                maxT = averT - 1;
            }
            else {
                minT = averT + 1;
            }
        }
        return answer;
    }
}