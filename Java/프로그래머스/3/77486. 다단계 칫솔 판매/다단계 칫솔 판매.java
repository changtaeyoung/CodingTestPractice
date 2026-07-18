import java.util.*;

class Solution {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> refP = new HashMap<>();
        Map<String, Integer> sumSells = new HashMap<>();
        
        for (int i = 0; i < enroll.length; i++) {
            refP.put(enroll[i], referral[i]);
        }
        
        for (int i = 0; i < seller.length; i++) {
            String cur = seller[i];
            int money = amount[i] * 100;
            
            while (!cur.equals("-")) {
                int share = money / 10;
                int get = money - share;
                
                sumSells.put(cur, sumSells.getOrDefault(cur, 0) + get);
                
                money = share;
                cur = refP.get(cur);
                
                if (share == 0) break;
            }
        }
        
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = sumSells.getOrDefault(enroll[i], 0);
        }
        
        return answer;
    }
}