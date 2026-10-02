import java.util.*;
/*
    무조건 선공은 O, 후공은 X
    선, 후 둘 다 맡는다
    O, X 번갈아가면서 표시 진행

    2개의 실수
    - 반대로 표시
    - 종료되었어도 게임 진행 -> O, X 둘 다 이기는 경우

    0이 나와야 할 때와 1이 나와야 할 때를 알아야 한다.
    O, X 2개의 개수를 센다.

    게임이 끝난 상태(isFinished = true)인데 아직 표시가 남아 있다면 0
    이미 끝난 상태인데 O 개수 - X 개수 == 0 이면 0
    끝나지 않은 상태에서 |O 개수 - X 개수| == 2 가 된다면 실수한 거니까 0
    아니라면 계속 진행

    board 크기가 3이라서 그냥 for문으로 다 확인해도 된다.
*/

class Solution {
        // ch가 가로 3줄, 세로 3줄, 대각선 2줄 중 하나라도 완성했는가
    private boolean win(String[] b, char ch) {
        for (int i = 0; i < 3; i++) {
            if (b[i].charAt(0) == ch && b[i].charAt(1) == ch && b[i].charAt(2) == ch) return true;
            if (b[0].charAt(i) == ch && b[1].charAt(i) == ch && b[2].charAt(i) == ch) return true;
        }
        if (b[0].charAt(0) == ch && b[1].charAt(1) == ch && b[2].charAt(2) == ch) return true;
        if (b[0].charAt(2) == ch && b[1].charAt(1) == ch && b[2].charAt(0) == ch) return true;
        return false;
    }
    
    public int solution(String[] board) {
        int[] num = new int[2];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'O') {
                    num[0]++;
                }
                else if (board[i].charAt(j) == 'X') {
                    num[1]++;
                }
            }
        }
        
        boolean oWin = win(board, 'O');
        boolean xWin = win(board, 'X');
        
        int d = num[0] - num[1];
        if (d != 0 && d != 1) return 0;          // 순서 자체가 불가능
        if (oWin && xWin) return 0;              // 둘 다 이길 수 없음
        if (oWin && d != 1) return 0;            // O가 이겼으면 O가 마지막 수
        if (xWin && d != 0) return 0;            // X가 이겼으면 X가 마지막 수
        return 1;
    }
}