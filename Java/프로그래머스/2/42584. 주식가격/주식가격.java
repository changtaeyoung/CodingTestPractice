import java.util.*;

class Solution {
    /*
        투포인터, 스택?
        
        생각 1: 스택 사용해서, 가격 인덱스를 넣고 그 스택의 peek의 값과 현 위치의 가격을 비교
        그럼 다음 인덱스에서 어떻게 비교를 할 것인가? 비교한 후 어떤 로직을 적용할 것인가? 
        
    */
    public int[] solution(int[] prices) {
        Stack<Integer> s = new Stack<>();
        int[] answer = new int[prices.length];
        
        s.push(0);
        for (int i = 1; i < prices.length; i++) {
            
            while (!s.isEmpty() && prices[s.peek()] > prices[i]) {
                answer[s.peek()] = i - s.peek();
                s.pop();
            }
            s.push(i);
        }
        
        while (!s.isEmpty()) {
            answer[s.peek()] = prices.length - 1 - s.peek();
            s.pop();
        }
        
        return answer;
    }
}