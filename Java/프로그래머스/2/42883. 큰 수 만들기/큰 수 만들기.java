import java.util.*;

class Solution {
    /*
        방향성을 아예 잡지 못했음
        -> 스택형식으로 구현.
    */
    
    public String solution(String number, int k) {
        Deque<Character> stack = new ArrayDeque<>();
    
        for (char c : number.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() < c) {
                stack.pollLast();
                k--;
            }
            stack.addLast(c);
        }
        
        while (k > 0) {
            stack.pollLast();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        sb.reverse();
        String answer = sb.toString();
        
        return answer;
    }
}