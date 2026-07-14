import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        Map<String, Integer> gemNum = new HashMap<>();
        Set<String> gemName = new HashSet<>();
        
        for (String gem : gems) {
            gemName.add(gem);
        }
        int totalGems = gemName.size();
        
        int left = 0, right = 0;
        int[] answer = new int[]{1, gems.length};
        
        while (right < gems.length) {
            gemNum.put(gems[right], gemNum.getOrDefault(gems[right], 0) + 1);
            right++;
            
            while (gemNum.size() == totalGems) {
                if (right - left < answer[1] - answer[0] + 1) {
                    answer[0] = left + 1;
                    answer[1] = right;
                }
                
                int cnt = gemNum.get(gems[left]) - 1;
                if (cnt == 0) {
                    gemNum.remove(gems[left]);
                } else {
                    gemNum.put(gems[left], cnt);
                }
                left++;
            }
        }
        
        return answer;
    }
}