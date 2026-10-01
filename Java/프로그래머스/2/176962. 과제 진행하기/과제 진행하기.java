import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        int[][] arr = new int[plans.length][3];
        
        for (int i = 0; i < plans.length; i++) {
            String[] hm = plans[i][1].split(":");
            arr[i] = new int[]{Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]), 
                               Integer.parseInt(plans[i][2]), i};
        }
        
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        
        Stack<int[]> s = new Stack<>();
        List<String> ans = new ArrayList<>();
        
        for (int i = 0; i < arr.length - 1; i++) {
            int[] cur = arr[i];
            int gap = arr[i + 1][0] - cur[0]; // 다음 시작과 현재 시작의 시간 차
            
            if (cur[1] <= gap) {
                ans.add(plans[cur[2]][0]);
                int left = gap - cur[1];
                
                while (left > 0 && !s.isEmpty()) {
                    int[] top = s.peek();
                    if (top[1] <= left) {
                        ans.add(plans[top[2]][0]);
                        left -= top[1];
                        s.pop();
                    }
                    else {
                        top[1] -= left;
                        left = 0;
                    }
                }
            }
            else {
                cur[1] -= gap;
                s.push(cur);
            }
        }
        
        ans.add(plans[arr[plans.length - 1][2]][0]);
        while(!s.isEmpty()) {
            ans.add(plans[s.pop()[2]][0]);
        }
        
        String[] answer = new String[ans.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}