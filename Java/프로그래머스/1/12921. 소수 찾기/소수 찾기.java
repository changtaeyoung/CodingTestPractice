class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 2; i <= n; i++) {            
            
            boolean isBreak = false;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (j != 1 && i % j == 0) {
                    isBreak = true;
                    break;
                }
            }
            
            if (!isBreak) {
                answer++;
            }
        }
        return answer;
    }
}