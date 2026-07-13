import java.util.*;

class Solution {
    /*
        최대 20만,
        여러 친구들이 뛸 예정이고, 0이 있지 않는 이상 1칸씩,
        0이 k칸이 있다면 k칸까지 뛸 수 있으나 거기까지만 가능.
        
        연속된 0의 수가 k개인 가를 확인해야함. 
        최대 연속 0의 개수를 max의 변수를 이용해서 갱신하며 계산한다?
        현재 위치한 곳이 0이면서 다음이 0일 경우
        현재 위치한 곳이 0이 아니면서 다음이 0일 경우
        현재 위치한 곳이 0 또는 0이 아닌 경우, 다음이 0이 아닌경우
    */
    public int solution(int[] stones, int k) {
        int minPerson = 1, maxPerson = 200000000, answer = -1;
        
        while (minPerson <= maxPerson) {
            int averPerson = (minPerson + maxPerson) / 2;
            // 총 0 개수, 연속된 0 개수
        
            int consZero = 0;
            boolean cannotCross = false;

            for (int i = 0; i < stones.length; i++) {
                if (stones[i] - averPerson < 0) {
                    consZero++;
                    if (consZero >= k) {
                        cannotCross = true;
                        break;
                    }
                } else {
                    consZero = 0;
                }
            }

            if (cannotCross) {
                maxPerson = averPerson - 1;
            } else {
                answer = averPerson;
                minPerson = averPerson + 1;
            }
        }
        
        return answer;
    }
}