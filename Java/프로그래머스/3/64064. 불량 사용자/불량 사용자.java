import java.util.*;
/*
    내가 생각한 방식
    1. banned_id에 적혀있는 애들 1개씩 user_id에 dfs를 이용해서 검수한다.
    2. 검수 성공한 애들만 List<String>에 넣는다 -> 그렇다면 List<List<String>>이 되어야겠지.
    3. banned_id 길이만큼 수행
    4. 각 List에서 하나씩 뽑아서 중복을 제거해야한다.
    5. Set<String[]>을 사용해야하는가? -> 하지만 근데 이 부분은 중복 제거가 잘 안되는 것으로 알고있음
    
    -> 힌트를 받고 난 후 로직
    어차피 ban아이디랑 user아이디랑 매칭시키는 것은 dfs를 사용하지 않아도 된다
    dfs는 아이디를 뽑아올 때
*/
class Solution {
    
    static List<List<Integer>> can;
    static Set<String> res;
    static boolean[] visited;
    
    private boolean match (String user, String ban) {
        
        if (user.length() != ban.length()) return false;
        for (int i = 0; i < ban.length(); i++) {
            if (ban.charAt(i) != '*' &&
               user.charAt(i) != ban.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    private void dfs (int idx) {
        if (idx == can.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sb.append(i).append(',');
                }
            }
            res.add(sb.toString());
            return;
        }
        
        for (int n : can.get(idx)) {
            if (visited[n]) continue;
            visited[n] = true;
            dfs(idx + 1);
            visited[n] = false;
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        can = new ArrayList<>();
        res = new HashSet<>();
        visited = new boolean[user_id.length];
        
        for (int i = 0; i < banned_id.length; i++) {
            List<Integer> l = new ArrayList<>();
            
            for (int j = 0; j < user_id.length; j++) {
                if (match(user_id[j], banned_id[i])) {
                    l.add(j);
                }
            }
            
            can.add(l);
        }
        
        dfs(0);
        
        return res.size();
    }
}