import java.util.*;
class Solution {
    public int solution(int[][] board) {
        int ans = 0; // 최댓값은 0부터 시작

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                
                // 값이 1인 칸에서만 정사각형 크기 계산
                if (board[i][j] == 1) {
                    // 첫 번째 행이거나 첫 번째 열이 아닌 경우에만 DP 점화식 적용
                    if (i > 0 && j > 0) {
                        int minLeftTop = Math.min(board[i - 1][j], board[i][j - 1]);
                        board[i][j] = Math.min(board[i - 1][j - 1], minLeftTop) + 1;
                    }
                    
                    // 점화식 적용 후, 혹은 원래 1이었던 값을 토대로 최댓값 갱신
                    ans = Math.max(ans, board[i][j]);
                }
            }
        }

        // 구한 한 변의 길이(ans)를 제곱하여 넓이 반환
        return ans * ans;
    }
}