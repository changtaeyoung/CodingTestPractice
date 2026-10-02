import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        
        int[][] arr = new int[plans.length][3];
        for (int i = 0; i < plans.length; i++) {
            String[] hm = plans[i][1].split(":");
            arr[i][0] = Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
            arr[i][1] = Integer.parseInt(plans[i][2]);
            arr[i][2] = i;
        }
        
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        
        Stack<int[]> s = new Stack<>();
        List<String> l = new ArrayList<>();
        
        for (int i = 0; i < arr.length - 1; i++) {
            int[] cur = arr[i];
            int gap = arr[i + 1][0] - cur[0];
            
            if (cur[1] <= gap) {
                l.add(plans[cur[2]][0]);
                int left = gap - cur[1];
                
                while (left > 0 && !s.isEmpty()) {
                    int[] top = s.peek();
                    if (top[1] <= left) {
                        l.add(plans[top[2]][0]);
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
        l.add(plans[arr[arr.length - 1][2]][0]);
        while (!s.isEmpty()) {
            l.add(plans[s.pop()[2]][0]);
        }
        
        String[] ans = new String[l.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = l.get(i);
        }
        return ans;
    }
}