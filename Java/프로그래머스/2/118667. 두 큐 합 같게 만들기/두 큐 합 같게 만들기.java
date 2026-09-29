import java.util.*;
/*
    int[] 배열 길이 30만
    첫 합을 미리 계산을 해 두고, 큐 2개를 만들어서, 왔다 갔닫 하면 될 거 같은데.
    
    14 - 3 = 11
    16 - 4 = 12
    
    18 - 3 = 15
    12 - 6
*/
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        for (int i = 0; i < queue1.length; i++) {
            sum1 += (long)queue1[i];
            q1.offer(queue1[i]);
            sum2 += (long)queue2[i];
            q2.offer(queue2[i]);
        }
        
        long total = (sum1 + sum2) / 2;
        
        // q1을 움직이도록 할 것이냐 q2를 움직이도록 할 것이냐.
        // 솔직히 지금 생각이 드는 건 그냥 q1을 움직일 때, q2를 움직일 때 2번의 반복문을 그냥 하면 안되나? 싶음
        // 그리디라고 하면
        // 현재 위치에서 두개의 peek를 구하고, 각 sum에서 뺐을 때, 그 total과 가까운 쪽을 선택하도록?
        // 더이상 만들어지지 않는다면 break문을 걸어줘야해...
        // 사실 Set을 만들어서 더이상 Set에 추가되는 원소가 없다면 break문을 거는 방식이 맞았을까 싶기도 하고..
        // 어차피 큐 2개의 원소 크기의 합동안 안만들어지면 빠꾸아님?
        int ans = 0;
        while (sum1 != total) {
            if (ans > (queue1.length + queue2.length) * 2) return -1;
            
            if (sum1 > total) {
                int num = q1.poll();
                q2.offer(num);
                sum1 -= num;
            }
            else {
                int num = q2.poll();
                q1.offer(num);
                sum1 += num;
            }
            ans++;
        }
        
        return ans;
    }
}