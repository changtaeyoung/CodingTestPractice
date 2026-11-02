import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int[][] tired = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        
        int pickNum = 0;
        for (int i = 0; i < picks.length; i++) {
            pickNum += picks[i];
        }
        
        int canPick = pickNum * 5;
        
        List<int[]> l = new ArrayList<>();
        int[] mNums = new int[3];
        for (int i = 0; i < Math.min(minerals.length, canPick); i++) {
            
            if (i != 0 && i % 5 == 0) {
                l.add(mNums);
                mNums = new int[3];
            }
            
            if (minerals[i].equals("diamond")) {
                mNums[0]++;
            }
            else if (minerals[i].equals("iron")) {
                mNums[1]++;
            }
            else {
                mNums[2]++;
            }
        }
        
        if (mNums[0] + mNums[1] + mNums[2] > 0) { // 남은 찌꺼기가 존재하면 리스트에 추가.
            l.add(mNums);
        }
        
        // 이러면 리스트에 작성은 되었을 테고.. 피로도가 큰 순서대로 처리하면 되겠지.
        Collections.sort(l, (a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return Integer.compare(b[2], a[2]);
                }
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(b[0], a[0]);
        });
        
        int idx = 0, answer = 0;
        for (int i = 0; i < l.size(); i++) {
            int[] cur = l.get(i);
            
            while (idx < 3 && picks[idx] == 0) idx++; // 곡괭이 없으면 다음 곡괭이로 넘어가
            
            for (int j = 0; j < cur.length; j++) {
                answer += tired[idx][j] * cur[j]; // 피로도 지수 * 개수
            }
            
            picks[idx]--; // 이번 곡괭이 썼으니까 없애고
        }
        
        return answer;
    }
}