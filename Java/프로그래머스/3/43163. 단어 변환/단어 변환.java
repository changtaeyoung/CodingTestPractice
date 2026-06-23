import java.util.*;

class Solution {
    /*
        1개 차이날 때만 변환 가능
        최소 몇단계인가? - BFS
    */
    static Map<String, Integer> visited;
    
    static void bfs (String str1, String str2, String[] arr) {
        Queue<String> q = new ArrayDeque<>();
        q.offer(str1);
        visited.put(str1, visited.getOrDefault(str1, 0) + 1);
        
        while (!q.isEmpty()) {
            String cur = q.poll();
            
            for (int i = 0; i < arr.length; i++) {
                int diffCnt = 0;
                for (int j = 0; j < cur.length(); j++) {
                    if (cur.charAt(j) != arr[i].charAt(j)) {
                        diffCnt++;
                    }
                }
                
                if (diffCnt == 1 && visited.get(arr[i]) == null) {
                    visited.put(arr[i], visited.getOrDefault(cur, 0) + 1);
                    q.offer(arr[i]);
                }
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean isTar = false;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                isTar = true;
                break;
            }
        }
        
        if (!isTar) {
            return 0;
        }
        
        visited = new TreeMap<>();
        Arrays.sort(words);
        bfs(begin, target, words);
        
        return visited.get(target) - 1;
    }
}