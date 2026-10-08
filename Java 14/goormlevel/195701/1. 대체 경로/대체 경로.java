import java.io.*;
import java.util.*;
/*
	최단 거리로 이동해야한다는 말 같고
	i일 뒤에는 i번째 도시 공사를 하니 이어진 모든 길을 사용 불가
	
*/
class Main {

	static boolean[] visited;
	
	private static int bfs (int start, int dest, List<List<Integer>> map) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{start, 1});
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int[] c = q.poll();

			if (c[0] == dest) return c[1];

			for (int next : map.get(c[0])) {
				if (!visited[next]) {
					visited[next] = true;
					q.offer(new int[]{next, c[1] + 1});
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // city num
		int m = Integer.parseInt(st.nextToken()); // road num
		int sc = Integer.parseInt(st.nextToken()); // start city
		int dc = Integer.parseInt(st.nextToken()); // destination city

		List<List<Integer>> graph = new ArrayList<>(); 
		for (int i = 0; i <= n; i++) { // 1base
			graph.add(new ArrayList<>());
		}
		visited = new boolean[n + 1];
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st1.nextToken());
			int e = Integer.parseInt(st1.nextToken());
			
			graph.get(s).add(e);
			graph.get(e).add(s); // 양방향
		}

		for (int i = 1; i <= n; i++) {
			Arrays.fill(visited, false);
			visited[i] = true;

			if (sc == i || dc == i) {
				System.out.println(-1);
				continue;
			}
			System.out.println(bfs(sc, dc, graph));
		}
		return;
	}
}