import java.util.*;

class Solution {
    /*
        아래부터 채움, 단, 위에서부터 빼야함
    */
    public int solution(int n, int w, int num) {
        int[][] boxes;
        if (n % w == 0) {
            boxes = new int[n / w][w];
        }
        else {
            boxes = new int[(n / w) + 1][w];
        }
        
        // num이 나오게 된다면 열을 기억해두는 것이 좋아보임
        int k = 1, col = 0, row = 0;
        for (int i = boxes.length - 1; i >= 0; i--) {
            if ((boxes.length - 1 - i) % 2 == 0) {
                for (int j = 0; j < boxes[i].length; j++) {
                    if (k <= n) {
                        boxes[i][j] = k;
                        if (k == num) { // 우측으로 갈 때
                            row = i;
                            col = j;
                        }
                        k++;
                    }
                }
            }
            else {
                for (int j = boxes[i].length - 1; j >= 0; j--) {
                    if (k <= n) {
                        boxes[i][j] = k;
                        if (k == num) { // 좌측으로 갈 떄
                            row = i;
                            col = j;
                        }
                        k++;
                    }  
                }
            }
        }
        
        if (row == 0) { // 맨 윗층에 있을 경우
            return 1;
        }
        
        if (boxes[0][col] == 0) { // 꺼내려는 상자 포함이니까
            return row;
        }
        else {
            return row + 1;
        }
    }
}