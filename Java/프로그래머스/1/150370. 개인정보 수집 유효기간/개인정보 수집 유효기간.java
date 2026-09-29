import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayD = 0; // 년,월,일 모두 하나로 모을거임
        String[] date = today.split("\\.");
        todayD = (Integer.parseInt(date[0]) * 12 + Integer.parseInt(date[1])) * 28 +
            Integer.parseInt(date[2]);
        
        Map<String, Integer> termsMap = new HashMap<>();
        for (String str : terms) {
            String[] sp = str.split(" ");
            termsMap.put(sp[0], Integer.parseInt(sp[1]) * 28); // 달을 일수로 변경
        }
        
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] ssp = privacies[i].split(" ");
            String[] privDate = ssp[0].split("\\.");
            int priv = (Integer.parseInt(privDate[0]) * 12 + Integer.parseInt(privDate[1])) * 28 +
                Integer.parseInt(privDate[2]);
            
            priv += termsMap.get(ssp[1]);
            
            if (todayD >= priv) {
                answer.add(i + 1);
            }
        }
        
        int[] ans = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        
        return ans;
    }
}