import java.util.*;

/*
    순서와 상관이 없이 들어가 있으면 일단 됨.
    0이 아닌 값들을 먼저 세고
    0인 값이 다 맞을 경우는 + 0의 개수, 다 틀릴 경우가 제일 낮은 순위일 테니까..
*/

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> wNums = new ArrayList<>();
        for (int i = 0; i < win_nums.length; i++) {
            wNums.add(win_nums[i]);
        }
        
        int ans = 0, zeroNum = 0;
        for(int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zeroNum++;
            }
            else {
                if (wNums.contains(lottos[i])) {
                    ans++;
                }
            }
        }
        
        // 0의 개수를 셌을 테고, 현재 맞춘 개수를 셌을 거야.
        // 0 or 1 6등, 2 5, 3 4, 4 3, 5 2, 6 1
        int[] answer = new int[2];
        if (ans + zeroNum > 1) { // 0인 것이 다 맞았다면
            answer[0] = 7 - (ans + zeroNum);
        }
        else { // 다 맞았는데도 불구, 0 또는 1이라면
            answer[0] = 6;
        }
        
        if (ans > 1) {
            answer[1] = 7 - ans;
        }
        else {
            answer[1] = 6;
        }
        
        return answer;
    }
}