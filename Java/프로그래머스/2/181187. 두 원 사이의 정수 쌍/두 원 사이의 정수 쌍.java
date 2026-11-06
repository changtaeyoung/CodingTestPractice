import java.util.*;

/*
    pow(r1, 2) <= pow(x, 2) + pow(y, 2) <= pow(r2, 2)
    를 생각해보면 됨.
*/

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        int tmp = 0;
        if (r1 > r2) {
            tmp = r1;
            r1 = r2;
            r2 = tmp;
        }
        
        long maxV = (long) r2 * r2, minV = (long) r1 * r1;
        
        for (int i = 1; i <= r2; i++) {
            long powX = (long) i * i;
            
            long maxY = (long) Math.floor(Math.sqrt(maxV - powX));
            long minY = 0;
            if (i < r1) {
                minY = (long) Math.ceil(Math.sqrt(minV - powX));
            }
            
            
            answer += (maxY - minY + 1);
        }
        
        return answer * 4;
    }
}