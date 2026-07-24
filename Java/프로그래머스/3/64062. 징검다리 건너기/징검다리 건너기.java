class Solution {
    /*
        일단 배열 크기 20만 이하. 즉, 브루트 포스 사용 불가
        
        건널 때마다 -1씩 되니까...
        
        생각 1: 갑자기 떠올랐는데 사람의 수를 이분 탐색 시켜보는 건 어떰?
        예를 들어서 뭐 stones에 있는 제일 큰 값을 가져와서.
        사람의 수를 - 시켜서 연속된 0의 길이를 세고, 
        -> 여기서 문제, stones 배열의 값을 변경하면 오염된다.. (전에 0이였던 값을 기억한다?)
        k보다 크다면 사람 수 줄이고, k보다 작다면 가능한 거고. (사람의 수를 더 늘려보는거지)
    */
    public int solution(int[] stones, int k) {
        int minP = 1, maxP = -1, answer = 0;
        for (int i = 0; i < stones.length; i++) {
            if (maxP < stones[i]) {
                maxP = stones[i];
            }
        }
        
        while (minP <= maxP) {
            int averP = (minP + maxP) / 2;
            boolean cannotCross = false;
            int consZero = 0;
            
            // 전에 0이 였던 값을 기억하는 것이 아닌, 
            // 현재 위치의 값이 0인지 아닌지에 따라 구분지으면 쉽게 풀 수 있다.
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] - averP < 0) {
                    consZero++;
                    
                    if (consZero >= k) {
                        cannotCross = true;
                        break;
                    }
                }
                else {
                    consZero = 0;
                }
            }
            
            if (cannotCross) {
                maxP = averP - 1;
            }
            else {
                answer = averP;
                minP = averP + 1;
            }
        }
        return answer;
    }
}