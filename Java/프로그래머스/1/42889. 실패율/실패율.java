import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] cnt = new int[N + 2];                 // 스테이지별 멈춰 있는 인원
        for (int s : stages) cnt[s]++;

        double[] failRate = new double[N + 1];
        int reached = stages.length;
        for (int i = 1; i <= N; i++) {
            failRate[i] = reached == 0 ? 0 : (double) cnt[i] / reached;
            reached -= cnt[i];
        }

        Integer[] order = new Integer[N];
        for (int i = 0; i < N; i++) order[i] = i + 1;

        Arrays.sort(order, (a, b) -> {
            if (failRate[a] != failRate[b]) return Double.compare(failRate[b], failRate[a]); // 실패율 내림차순
            return Integer.compare(a, b);                                                    // 같으면 번호 오름차순
        });

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) answer[i] = order[i];   // Integer → int 자동 변환
        return answer;
    }
}