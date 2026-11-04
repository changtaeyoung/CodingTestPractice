import java.util.*;
/*
    하나의 열을 선택했을 때, 그 위치에서 DFS를 통해 그 넓이를 구해야함.
    visited가 이미 수행된 아이는 적용 불가.
    
    근데 visited한 애들을 다시 dfs할 수도 없고. 어떤 식으로 저 넓이의 값을 기억할 것인지에 대해서 고민해봐야함
    그 visited한 열의 위치에 넓이에 대한 값을 넣는다면?
    예를 들어서 visited[8]에서 0~2에는 8을 넣는거지. 우측 또는 좌측으로 이동할 때마다 갱신시켜주는 거고
*/
class Solution {
    
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static int[][] visited;
    static int count = 0;
    
    private void bfs(int x, int y, int n) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = n;
        count++;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                    if (visited[nx][ny] == 0 && map[nx][ny] == 1) {
                        visited[nx][ny] = n;
                        count++;
                        q.offer(new int[]{nx, ny, n});
                    }
                }
            }
        }
    }

    
    public int solution(int[][] land) {
        map = land;
        visited = new int[land.length][land[0].length];
        
        int num = 1;
        Map<Integer, Integer> areas = new HashMap<>();
        for (int j = 0; j < land[0].length; j++) {
            
            for (int i = 0; i < land.length; i++) {
                if (land[i][j] == 1 && visited[i][j] == 0) {
                    bfs(i, j, num);
                    areas.put(num, count);
                }
                num++;
                count = 0; // 
            }
        }
        
        int answer = 0;
        
        for (int j = 0; j < land[0].length; j++) {
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < land.length; i++) {
                if (land[i][j] == 1) {
                    if (!l.contains(visited[i][j])) {
                        l.add(visited[i][j]);
                    }
                }
            }
            
            int sum = 0;
            for (int k = 0; k < l.size(); k++) {
                sum += areas.get(l.get(k));
            }
            
            if (answer < sum) {
                answer = sum;
            }
        }
        
        return answer;
    }
}