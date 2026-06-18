import java.util.*;

class Solution {
    /*
        min {, 16, 123}
        max {123}
    */
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String order : operations) {
            
            if (order.charAt(0) == 'I') { // I
                int num = Integer.parseInt(order.substring(2));
                minpq.offer(num);
                maxpq.offer(num);
            }
            else { // D
                
                if (!minpq.isEmpty() && !maxpq.isEmpty()) { // 당연히 빼려면 큐에 값이 있어야지.

                    if (order.substring(2).equals("-1")) { // 최솟값 빼기
                        maxpq.remove(minpq.poll());
                    }
                    else { // 최댓값 빼기
                        minpq.remove(maxpq.poll());
                    }
                }
            }
        }
        
        if (maxpq.isEmpty() && minpq.isEmpty()) {
            return new int[]{0, 0};
        }
        else {
            return new int[]{maxpq.poll(), minpq.poll()};
        }
    }
}