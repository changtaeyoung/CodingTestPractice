import java.util.*;

class Solution {
    /*
        이런 문제는 시작 시간 또는 끝나는 시간으로 정렬해서 푸는 것이 좋아 보인다.
        + 계산할 때 불편하니까 걍 시간을 모두 분으로 맞추는 것이 더 나을 듯. h*60 + m 느낌
        
        1차 시도: 끝나는 시간으로 정렬한다. 
        1개의 방을 썼고, 그 방의 예약이 끝나지 않아서 방을 하나 더 추가했다고 치면,
        전에 썼던 방의 시간이 끝났을 때를 대비해야할 대비책
    */
    public int solution(String[][] book_time) {
        int[][] bookingTimes = new int[book_time.length][2];
        
        for (int i = 0; i < book_time.length; i++) {
            for (int j = 0; j < book_time[i].length; j++) {
                String[] time = book_time[i][j].split(":");
                int hour = Integer.parseInt(time[0]) * 60;
                int miniute = Integer.parseInt(time[1]);
                
                bookingTimes[i][j] = hour + miniute;
            }
        }
        
        // 예약 첫 시간으로 정렬
        Arrays.sort(bookingTimes, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int answer = 0;
        for (int i = 0; i < bookingTimes.length; i++) {
            int checkIn = bookingTimes[i][0];
            
            while (!pq.isEmpty()) {
                if (pq.peek() <= checkIn) {
                    pq.poll();
                }
                else {
                    break;
                }
            }
            
            pq.offer(bookingTimes[i][1] + 10);
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }
}