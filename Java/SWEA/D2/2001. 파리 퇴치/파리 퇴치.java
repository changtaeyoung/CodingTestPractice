import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
            	for (int j = 0; j < n; j++) {
                	map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int maxV = -1;
            
			for (int i = 0; i <= n - m; i++) {
                for (int j = 0; j <= n - m; j++) {
                    int sum = 0;
                	// 좌상단의 x, y 좌표가 i, j인 거임 여기서 m만큼의 정사각형의 개수를 구하는 거지.
                    for (int k = i; k < i + m; k++) {
                        for (int l = j; l < j + m; l++) {
                        	sum += map[k][l];
                        }
                    }
                    
                    if (maxV < sum) {
                        maxV = sum;
                    }
                }
            }
            System.out.println("#" + test_case + " " + maxV);
		}
	}
}