import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[2] == b[2]) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                }
                else {
                    return Integer.compare(a[1], b[1]);
                }
            }
            else {
                return Integer.compare(a[2], b[2]);
            }
        });
        
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        int curT = 0, idx = 0, num = 0, sum = 0;
        
        while (num < jobs.length) {
            
            while (idx < jobs.length && jobs[idx][0] <= curT) {
                pq.offer(new int[]{idx, jobs[idx][0], jobs[idx][1]});
                idx++;
            }
            
            if (pq.isEmpty()) {
                curT = jobs[idx][0];
                continue;
            }
            
            int[] c = pq.poll();
            curT += c[2];
            sum += curT - c[1];
            num++;
        }
        
        return sum / jobs.length;
    }
}