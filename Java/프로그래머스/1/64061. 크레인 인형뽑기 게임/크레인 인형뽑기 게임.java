import java.util.*;

class Solution {
    
    /*
        내가 처음 생각난 로직은
        stack을 이용하고, stack의 peek와 현재 뽑은 원소를 비교했을 때 같다면, stack을 pop을 하는거.
        그리고 +1을 하는거지.
        
        주의해야할 사항, moves는 1base이므로 -1한 것을 이용해야함
    */
    
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> s = new Stack<>();
        int answer = 0;
        
        for (int i = 0; i < moves.length; i++) {
            int col = moves[i] - 1;
            for (int j = 0; j < board.length; j++) { // 세로 탐색이 되어야하니까.
                if (board[j][col] == 0) continue;
                
                // 스택에 저장되어있는 애랑 동일하다면
                if (!s.isEmpty() && s.peek() == board[j][col]) {
                    s.pop();
                    answer += 2;
                }
                else { // 동일하면 지워지니까 저장 안해도 돼. 그게 아니라면 넣어야지
                    s.push(board[j][col]);
                }
                
                board[j][col] = 0; // 이미 쓰인 것, 모두 0이여서 안쓰든 그 위치는 0으로 대입해야지 
                break;
            }
        }
        
        return answer;
    }
}