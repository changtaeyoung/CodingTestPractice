import java.util.*;

class Solution {
    /*
        우선순위 높은 순
        소유 시간이 짧, 요청 시간이 빠름, 작업의 번호가 작음
        
        작업 마치기, 요청 겹칠 경우
        요청 먼저 대기 큐에 저장하고 큐에서 꺼내서 작업 함
        
        요청 시점, 소요 시간이 주어짐
    */
    public int solution(int[][] jobs) {
        // int[]에는 소유시간, 요청시간, 작업의 번호가 들어갈 예정
        // 최소 힙을 만들어야 함
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[2], b[2]);
                }
                else {
                    return Integer.compare(a[1], b[1]);
                }
            }
            else {
                return Integer.compare(a[0], b[0]);
            }
        });                                                     
        
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        int curTime = 0, total = 0, idx = 0, n = jobs.length, num = 0;
        // jobs를 요청시간 기준으로 미리 정렬해두면 idx로 순차 확인 가능

        while (num < n) {
            // curTime까지 요청된 모든 job을 큐에 넣기 (하나가 아니라 while로 전부!)
            while (idx < n && jobs[idx][0] <= curTime) {
                pq.offer(new int[]{jobs[idx][1], jobs[idx][0], idx});
                idx++;
            }

            if (pq.isEmpty()) {
                // 처리할 게 없으면 다음 요청 시점으로 시간 점프
                curTime = jobs[idx][0];
                continue;
            }

            int[] cur = pq.poll();
            curTime += cur[0];
            total += (curTime - cur[1]);
            num++;
        }
        
        return total / jobs.length;
    }
}