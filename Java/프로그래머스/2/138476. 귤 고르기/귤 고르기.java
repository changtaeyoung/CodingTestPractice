import java.util.*;

/*
    개수를 세는 맵을 만들고, 그 맵의 사이즈가 서로다른 귤의 종류니까 그 값이 최소가 되도록 하는.
    k개를 선택할건데. 어떻게 선택하느냐가 문제.
    엔트리셋을 해야하나? 아 이거 잘 모르는데...
*/

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> num = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i++) {
            num.put(tangerine[i], num.getOrDefault(tangerine[i], 0) + 1);
        }
        
        List<Integer> l = new ArrayList<>(num.values());
        Collections.sort(l, Collections.reverseOrder());
        
        int ans = 0;
        for (int i = 0; i < l.size(); i++) {
            if (k <= 0) break;
            else {
                k -= l.get(i);
                ans++;
            }
        }
        return ans;
    }
}