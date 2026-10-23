import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;

        // 이름 -> 번호
        Map<String, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++) idx.put(friends[i], i);

        int[][] giftmap = new int[n][n];
        int[] score = new int[n]; // 선물 지수 = 준 수 - 받은 수

        for (int i = 0; i < gifts.length; i++) {
            String[] str = gifts[i].split(" ");
            int give = idx.get(str[0]);
            int get = idx.get(str[1]);
            giftmap[give][get]++;
            score[give]++;
            score[get]--;
        }

        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (giftmap[i][j] != giftmap[j][i]) {
                    if (giftmap[i][j] > giftmap[j][i]) next[i]++;
                    else next[j]++;
                }
                else if (score[i] != score[j]) {
                    if (score[i] > score[j]) next[i]++;
                    else next[j]++;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) ans = Math.max(ans, next[i]);
        return ans;
    }
}