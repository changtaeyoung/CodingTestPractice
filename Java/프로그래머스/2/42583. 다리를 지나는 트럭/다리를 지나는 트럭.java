import java.util.*;
class Solution {
    /*
        다리를 건너는데, bridge_length의 초만큼 소요가 되겠네.
        stack쪽에서 무게를 따라갈 수 있는 변수가 하나 필요할 테고, 스택을 쓰면 될거같은데. 
        큐는 들어온 순서와 나가는 순서를 적용하기 위한 거고.
        스택과 큐는 인덱스로 사용하면 될거같은데?
        
        stack은 굳이? 왜냐면 무게를 따라갈 변수가 있다면 스택은 굳이 필요 없어보임
        결국 bridge_length가 2칸이면 3초가 있으면 가는 거니까, bridge_length + 1초가 지나면 q에서 빼는거지.
    */
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> q = new ArrayDeque<>(); // {나가는 시각, idx}
        int sumW = 0, time = 0, idx = 0;
        
        // 종료 조건: idx가 끝났는지가 아니라, 다리 위 트럭(큐)이 완전히 빌 때까지
        while (!q.isEmpty() || idx < truck_weights.length) {
            time++;
            
            // 현재 시간이 트럭이 나올 시간이라면 빼야지, 무게 총합에서도 빼고.
            if (!q.isEmpty() && q.peek()[0] == time) {
                int[] cur = q.poll();
                sumW -= truck_weights[cur[1]];
            }
            
            // 아직 대기 중인 트럭이 있고, 지금 올려도 무게 제한을 넘지 않는다면 진입 시도
            // (큐가 비어있든 아니든 로직을 나눌 필요 없이, 조건 하나로 통일)
            if (idx < truck_weights.length && sumW + truck_weights[idx] <= weight) {
                sumW += truck_weights[idx]; // 큐에 넣는 시점에 sumW도 반드시 함께 갱신
                q.offer(new int[]{time + bridge_length, idx});
                idx++;
            }
            
            // 나머지 값들에 있어서, 불가능한 경우의 수들만 있으므로 시간만 보내면 됨.
        }
        
        return time;
    }
}