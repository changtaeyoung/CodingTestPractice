import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // k 이상 신고된 유저는 정지
        Map<String, Set<String>> sMap = new HashMap<>(); // 신고 당한 횟수
        Map<String, Set<String>> rMap = new HashMap<>(); // 신고한 사람
        
        int[] ans = new int[id_list.length];
        
        for (int i = 0; i < report.length; i++) {
            String[] str = report[i].split(" ");
            
            // 신고한 횟수 세기
            if (rMap.get(str[0]) == null) {
                rMap.put(str[0], new HashSet<>());
                rMap.get(str[0]).add(str[1]);
            }
            else {
                rMap.get(str[0]).add(str[1]);
            }
            
            // 신고 당한 횟수 세기
            if (sMap.get(str[1]) == null) {
                sMap.put(str[1], new HashSet<>());
                sMap.get(str[1]).add(str[0]);
            }
            else {
                sMap.get(str[1]).add(str[0]);
            }
        }
        
        List<String> l = new ArrayList<>(); // black list
        
        for (int i = 0; i < id_list.length; i++) {
            if (sMap.get(id_list[i]) != null && sMap.get(id_list[i]).size() >= k) {
                l.add(id_list[i]);
            }
        }
        
        for (int i = 0; i < id_list.length; i++) {
            
            if (rMap.get(id_list[i]) == null) continue;
            
            for (int j = 0; j < l.size(); j++) {
                if (rMap.get(id_list[i]).contains(l.get(j))) {
                    ans[i]++;
                }
            }
        }
        
        return ans;
    }
}