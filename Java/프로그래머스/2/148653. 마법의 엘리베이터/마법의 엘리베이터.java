class Solution {
    /*
        storey 1억이네
        16일 경우는 +1 * 4, -10 * 2
        그리디하게 간다면, 6~9까지는 다음 10으로 가는 것이 좋고, 1~4는 0으로 내려가는 것이 더 좋음
    */
    
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int num = storey % 10;
            
            if (num > 5) {
                answer += (10 - num);
                storey += (10 - num);
            }
            else if (num < 5){
                answer += num;
            }
            else {
                answer += 5;
                if ((storey / 10) % 10 >= 5) {
                    storey += 5;
                }
            }
            
            storey /= 10;
        }
        return answer;
    }
}