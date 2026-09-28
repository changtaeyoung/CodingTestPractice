import java.util.*;

class Solution {
    /*
        diff <= level -> time_cur 시간을 이용해 해결
        diff > level -> diff - level 틀림
        틀렸을 때 - time_cur 시간 사용, 추가 time_prev 사용 (다시 풀 때는 틀리지 X)
        그만큼 틀린 후 Time_cur 사용해서 푼다
        
        숙련도의 최솟값을 구해야함. 30만개, 제한은 10의 15승. 엄청 크니까 이분탐색도 생각해봐야할 듯 함
        숙련도의 크기로 하는 이분탐색을 만들고 최솟값을 구하니 구해도 계속해서 내려가야하는 구조인 듯 함
    */
    public int solution(int[] diffs, int[] times, long limit) {
        long minE = 1, maxE = 0;
        long answer = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (maxE < diffs[i]) maxE = diffs[i];
        }
        
        while (minE <= maxE) {
            long averE = (minE + maxE) / 2;
            long total = 0; 
            
            for (int i = 0; i < diffs.length; i++) {
                if (diffs[i] > averE) { // 숙련도가 낮으면 그 전의 합
                    if (i == 0) { // 전 라운드가 없으니까
                        total += (times[i] * (diffs[i] - averE)) + times[i];
                    }
                    else { 
                        total += ((times[i - 1] + times[i]) * (diffs[i] - averE)) + times[i];
                    }
                }
                else { // 숙련도가 더 높으니까
                    total += times[i];
                }
            }
            
            if (total <= limit) {
                answer = averE;
                maxE = averE - 1;
            }
            else {
                minE = averE + 1;
            }
        }
        
        return (int)answer;
    }
}