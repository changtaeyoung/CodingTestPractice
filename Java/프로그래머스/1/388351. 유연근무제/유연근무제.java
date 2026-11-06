import java.util.*;
/*
    출근 희망 시각 + 10분까지 출근 - 토/일 출근은 이벤트 영향 X
    시간 그대로 활용 가능한가? -> 0050일 경우 100을 더하고 -50을 하면 되지 않음? 55면 그냥 50을 더하면 되잖아
    
    이벤트 시작 날짜가 중요한 지점 - 어떻게 활용?
    
    timelogs[i]에서 i + startday % 7 한게 1,2,3,4,5 이면 쓴다?
*/
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i < timelogs.length; i++) {
            int limit = 0; // 제한 시각
            if (schedules[i] % 100 >= 50) {
                limit = schedules[i] + 50;
            }
            else {
                limit = schedules[i] + 10;
            }
            boolean isAllValid = true;
            for (int j = 0; j < timelogs[i].length; j++) {
                if ((j + startday) % 7 >= 1 && (j + startday) % 7 <= 5) {
                    if (timelogs[i][j] > limit) {
                        isAllValid = false;
                        break;
                    }
                }
            }
            
            if (isAllValid) answer++;
        }
        
        return answer;
    }
}