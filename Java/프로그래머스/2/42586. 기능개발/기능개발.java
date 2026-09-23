import java.util.*;

class Solution {
    /*
        뒤 기능은 앞에 있는 기능보다 먼저 개발 될 수 있지만 배포는 앞에 있는 기능과 같이 배포됨
        
        그렇다면 각 기능들의 배포되는 날짜를 구하고, 앞의 기능과 함께 처리
        
        100 이상이 된다면 배포 처리
        각 남은 날짜를 큐에다 대입 후, 앞에 빠져나간 값을 기억하고, 그 값보다 다음 값이 작다면 바로 빼
    */
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) { // 완벽하게 나뉘면 그 값 대입
                q.offer((100 - progresses[i]) / speeds[i]);
            }
            else { // 나뉘지 않는다면 +1을 해줘야 함
                q.offer(((100 - progresses[i]) / speeds[i]) + 1);
            }
        }
        
        int prevTime = q.poll(), cnt = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (prevTime >= cur) { // 전 기능이 배포되는 타임
                cnt++;
            }
            else { // 전 기능이 배포되는 것보다 시간이 오래걸렸다면
                ans.add(cnt);
                cnt = 1;
                prevTime = cur;
            }
        }
        // 지금 위 코드는 마지막 원소가 prevTime에 들어가고 while 조건에 맞지 않아서 빠져 나온 거 같음
        ans.add(cnt);
        
        
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}