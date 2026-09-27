import java.util.*;

class Solution {
    
    /*
        일단 시각 표시 주의.
        50분 이후 부터는 00 ~ 으로 처리해야함.
        토, 일은 이벤트 영향 끼치지 않음.
    */
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int ans = 0;
        
        for (int i = 0; i < timelogs.length; i++) {
            int empNo = i, limit = 0;
            int[] everyday = new int[7]; 
            boolean canGet = true;
            
            // 출근 인정 시각 구하기.
            if (schedules[i] % 100 >= 50) {
                limit = schedules[i] + 50; // 시각이 바뀌어야하니 + 100, 분에 10 더해야하고, -60되어야하니.
            }
            else {
                limit = schedules[i] + 10; 
            }
            
            // startday때문에 요일이 바뀔텐데
            // startday = 1이면 그대로 ㅇ,ㅎ,ㅅ,ㅁ,ㄱ
            // 2면 ㅎ ㅅ ㅁ ㄱ ㅌ ㅇ ㅇ
            // 월~금만을 추출할 수 있는 방법이 뭘까...
            
            for (int j = 0; j < timelogs[i].length; j++) {
                if (j + (startday - 1) > 6) {
                    everyday[j + (startday - 1) - 7] = timelogs[i][j];
                }
                else {
                    everyday[j + (startday - 1)] = timelogs[i][j];
                }
            }
            
            for (int j = 0; j < 5; j++) { // 월~금까지만
                if (everyday[j] > limit) {
                    canGet = false;
                    break;
                }
            }
            
            if (canGet) {
                ans++;
            }
        }
        
        return ans;
    }
}