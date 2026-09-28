import java.util.*;

class Solution {
    /*
        1초마다 x 회복, t초 연속 성공시 y회복
        당하는 순간에는 체력 회복 안됨
        
        이 문제는 time을 따라가면서 회복과 공격을 통한 +/-를 동시다발적으로 진행하는 것이 맞는 거 같은데
        우선순위 큐는 필요 없는게 어차피 공격 시간 기준 오름차순 정렬되어있네.
    */
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 시간 추적, 연속 힐 시간, 공격 시간 인덱스, 현재 피
        int time = 0, consHeal = 0, idx = 0, curHealth = health; 
        
        while (idx < attacks.length) { // 공격이 끝난 시점까지니까
            if (curHealth <= 0) { // character dead
                return -1;
            }
            
            // 공격 시간일 경우
            if (time == attacks[idx][0]) {
                consHeal = 0;
                curHealth -= attacks[idx][1];
                idx++;
            }
            else { // 공격 시간이 아닌 경우
                curHealth += bandage[1];
                consHeal++;
                
                if (consHeal == bandage[0]) { // 추가 체력 회복 조건 달성
                    curHealth += bandage[2];
                    consHeal = 0;
                }
            }
            
            // 일단 피 회복 시키고, 최대 체력보다 커지면 최대 체력 다시 대입
            if (curHealth > health) curHealth = health;
            time++; // 1초 경과...
        }
        
        return curHealth <= 0 ? -1 : curHealth;
    }
}