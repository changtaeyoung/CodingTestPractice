import java.util.*;
/*
    과제 시작 시간 -> 시작
    진행중인 과제가 있다면 멈추고 새로운 과제 시작
    과제 끝냈을 때 -> 겹치는 과제가 있다면 새로 시작해야하는 과제부터 진행
    멈춘 과제 여러 개면 가장 최근 멈춘 과제 시작
    
    큐가 필요할거같은데. 우선순위 큐가.
    
    일단 시간과 같은 경우는 그냥 int type으로 바꾸는게 맘 편해.
    
*/
class Solution {
    public String[] solution(String[][] plans) {
        // 시작 시간, 끝나는 시각, 플랜들 배열에서의 인덱스를 저장해놔야할 듯 함.
        // 끝나는 시간이 제일 우선이니까 끝나는 시각 오름차순. 
        // 같을 경우는 시작 시간이 느린 게 최신이니까. 그것을 먼저 빼야하니, 내림차순으로 우선순위 큐 저장
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(b[0], a[0]);
            }
            return Integer.compare(a[1], b[1]);
        }); // 정렬 기준 필요
        
        for (int i = 0; i < plans.length; i++) {
            String[] str = plans[i][1].split(":");
            int sTime = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
            int eTime = sTime + Integer.parseInt(plans[i][2]);
            pq.offer(new int[]{sTime, eTime, i});
        }
        System.out.println("우선순위 큐 사이즈: " + pq.size());
        
        String[] answer = new String[plans.length];
        int idx = 0;
        while (!pq.isEmpty()) {
            answer[idx] = plans[pq.poll()[2]][0];
            idx++;
        }
        
        return answer;
    }
}