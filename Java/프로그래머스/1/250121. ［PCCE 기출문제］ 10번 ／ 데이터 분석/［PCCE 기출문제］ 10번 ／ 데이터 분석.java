import java.util.*;
/*
    ext value < val_ext, sort_by (asc)
*/
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> list = new HashMap<>();
        list.put("code", 0);
        list.put("date", 1);
        list.put("maximum", 2);
        list.put("remain", 3);
        
        List<int[]> l = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            int num = list.get(ext);
            
            if (data[i][num] < val_ext) {
                l.add(data[i]);
            }
        }
        
        int sortIdx = list.get(sort_by);
        Collections.sort(l, (a, b) -> Integer.compare(a[sortIdx], b[sortIdx]));
        
        int[][] answer = new int[l.size()][4];
        for (int i = 0; i < l.size(); i++) {
            answer[i] = l.get(i);
        }
        
        return answer;
    }
}