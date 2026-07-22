import java.util.*;

class Solution {
    /*
        도착 지점은 distnace, n개의 바위 제거
        최솟값 중 최댓값
        
        바위 오름차순으로 정렬
        
        
    */
    static boolean isValid(int[] rockArr, int len, int n, int finish) {
        int lastPos = 0, rmvCnt = 0;
        
        for (int i = 0; i < rockArr.length; i++) {
            
            if (rockArr[i] - lastPos < len) {
                rmvCnt++;
            }
            else {
                lastPos = rockArr[i];
            }
        }
        
        if (finish - lastPos < len) {
            rmvCnt++;
        }
        
        return rmvCnt <= n;
    }
    
    public int solution(int distance, int[] rocks, int n) {
        
        Arrays.sort(rocks);
        int lowDist = 1, highDist = distance, answer = 0;
        
        while (lowDist <= highDist) {
            int averDist = (lowDist + highDist) / 2;
            
            if (isValid(rocks, averDist, n, distance)) {
                answer = averDist;
                lowDist = averDist + 1;
            }
            else {
                highDist = averDist - 1;
            }
        }
        
        return answer;
    }
}