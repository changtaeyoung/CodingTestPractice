class Solution {
    
    /*
        중간에 만들어지는 것이 아닌, 모두 다 끝나고 target인 지를 확인해야함
    */
    static int answer = 0;
    
    static void dfs (int[] numbers, int idx, int sum, int target) {
        
        if (idx == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        
        dfs(numbers, idx + 1, sum + numbers[idx], target);
        dfs(numbers, idx + 1, sum - numbers[idx], target);
    }
    
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, 0, 0, target);
        return answer;
    }
}