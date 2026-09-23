import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> ans = new ArrayList<>();
        int prev = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != prev) {
                ans.add(arr[i]);
            }
            prev = arr[i];
        }
        
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}