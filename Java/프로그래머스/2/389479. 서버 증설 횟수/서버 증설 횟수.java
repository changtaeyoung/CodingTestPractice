import java.util.*;

class Solution {
    /*
        시간대 별로 플레이어 수가 나온다.
        1 서버당 m명을 커버할 수 있다.
        최대 운영 가능 시간은 k
        처음에는 1이였겠지. 그러면 m명 미만은 이미 커버되고 있었을 테고.
        그리고 플레이어가 들어온 순간, players[i] / m을 할테고 나머지 있든 없든 +1.
        우선순위 큐를 쓴다? 그러면 끝나는 시각으로 맞춰서 해버리는거지...
        
        시각 변화를 통해서 이용하는 디스크 스케줄러같은 문제인건가?
        
        종료 시각은 k로 모두 똑같기 때문에 우선순위 큐가 오버한 것일 수도 있어 List만을 써도 되긴 할수도...
        근데 난 이게 편한 거 같아서 그냥 쓸래..
    */
    public int solution(int[] players, int m, int k) {
        // (종료시각, 증설 대수) 증설 종료 시각으로 우선순위 큐 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0])); 
        
        int serverNum = 0, ans = 0;
        for (int i = 0; i < players.length; i++) {
            int prevS = serverNum;
            
            // 증설했던 서버가 존재하고 끝나는 시각이라면
            if (!pq.isEmpty() && pq.peek()[0] == i) {
                serverNum -=pq.poll()[1]; // 증설한 서버 대수만큼 삭제
            }
            
            // 현재 서버가 플레이어 수를 감당 불가능
            int need = players[i] / m;
            if (need > serverNum) {
                int addServer = need - serverNum;
                ans += addServer;
                serverNum += addServer;
                pq.offer(new int[]{i + k, addServer});
            }

            // 감당가능하면 패스
        }
        
        return ans;
    }
}