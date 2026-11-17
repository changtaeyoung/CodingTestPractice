import java.util.*;
import java.io.*;

class Solution
{
    static int[][] map;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int k;
    
    private static int isValid(int x, int y) {
        int sum = 0;
        for (int d = 0; d < 2; d++) {
            // 이전 칸이 흰 칸이면 구간의 시작점이 아니므로 건너뜀
            int px = x - dx[d];
            int py = y - dy[d];
            if (px >= 0 && py >= 0 && map[px][py] == 1) continue;

            int cnt = 0;
            int nx = x;
            int ny = y;
            while (nx < map.length && ny < map.length && map[nx][ny] == 1) {
                cnt++;
                nx += dx[d];
                ny += dy[d];
            }
            if (cnt == k) sum++;
        }
        return sum;
    }
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
            	st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                	map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int ans = 0;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1) {
						ans += isValid(i, j);
                    }
                }
            }
             System.out.println("#" + test_case + " " + ans);
		}
	}
}