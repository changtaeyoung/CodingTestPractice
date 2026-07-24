import java.util.*;

class Solution {
    /*
        병사를 막는 방식에 있어서, 병사를 사용하느냐 스킬을 사용하느냐. 스킬은 k번, 병사는 n번 소환 가능.
        
        라운드가 정해져있기 때문에 정렬은 하면 안돼. enemy의 배열도 100만으로 꽤 크기 때문에 브루트 포스도 안돼.
        
        그렇다면, 라운드마다 필요 병사를 누적시키고, 
        n에서 빼고 음수가 된다면, 가장 큰 놈을 스킬로 막을 수 있도록 코드를 구현하면 되지 않을까?
    */
    public int solution(int n, int k, int[] enemy) {
        
        // 최대 힙을 이용함으로써, 스킬을 사용할 라운드를 책정
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int leftSoldier = n, leftSkill = k, answer = 0;
        for (int i = 0; i < enemy.length; i++) {
            // 병사를 빠르게 먼저 소진 시키고, 그 enemy에 해당하는 값을 pq에 계속 삽입 시킨다.
            leftSoldier -= enemy[i];
            pq.offer(enemy[i]);
            
            if (leftSoldier < 0) {
                if (leftSkill > 0 && !pq.isEmpty()) {
                    leftSoldier += pq.poll();
                    leftSkill--;
                }
                else {
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}