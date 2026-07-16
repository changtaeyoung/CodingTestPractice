import java.util.*;

class Solution {
    /*
        갈색의 타일 수와 노란색의 타일 수만 주어졌다보니, 어떻게 해야할까
        
        일단 갈색 + 노란색 타일을 하면 넓이가 나온다.
        w * h = brown + yellow
        
    */
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int area = brown + yellow;
        
        for (int i = area; i > 0; i--) { // i를 가로, 몫을 세로
            if(area % i == 0) {
                int height = area / i;
                
                if (i >= height && yellow == (i - 2) * (height - 2)) {
                    answer[0] = i;
                    answer[1] = height;
                    break;
                }
            }
        }
        return answer;
    }
}