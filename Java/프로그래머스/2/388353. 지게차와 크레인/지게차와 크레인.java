import java.util.*;
/*
    알파벳 1개 -> 지게차 이용 -> 접근 가능한 컨테이너 꺼냄 -> 그 알파벳을 찾고, 바깥으로 나갈 수 있는 알파벳인지 확인
    알파벳 2개 -> 크레인을 사용해 요청된 종류 모두 꺼냄 (BB), (AB)
    
    크레인은 모두 꺼내기 가능
*/
class Solution {
    
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    private boolean dfs (int x, int y) {
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                return true;
            }
            
            if (map[nx][ny] == ' ' && !visited[nx][ny]) {
                visited[nx][ny] = true;
                
                if (dfs(nx, ny)) return true;
            }
        }
        return false;
    }
    
    public int solution(String[] storage, String[] requests) {
        int n = storage.length, m = storage[0].length();
        int answer = n * m, eraseCnt = 0;
        map = new char[n][m];
        
        
        for (int i = 0; i < storage.length; i++) {
            map[i] = storage[i].toCharArray();
        }
        
        for (int i = 0; i < requests.length; i++) {
            
            if(requests[i].length() == 1) { // 지게차
                char c = requests[i].charAt(0);
                
                for (int j = 0; j < map.length; j++) {
                    for (int k = 0; k < map[j].length; k++) {
                        if (map[j][k] == c) {
                            visited = new boolean[n][m];
                            if (dfs(j, k)) {
                                map[j][k] = '1'; // 1로 바꾸고 한번에 처리
                            }
                        }
                    }
                }
                
                for (int j = 0; j < map.length; j++) {
                    for (int k = 0; k < map[j].length; k++) {
                        if (map[j][k] == '1') {
                            map[j][k] = ' ';
                            eraseCnt++;
                        }
                    }
                }
            }
            else { // 크레인                 
                String str = requests[i];
                for (int j = 0; j < map.length; j++) {
                    for (int k = 0; k < map[j].length; k++) {
                        if (str.charAt(0) == map[j][k] || str.charAt(1) == map[j][k]) {
                            map[j][k] = ' ';
                            eraseCnt++;
                        }
                    }
                }
            }
        }
    
        return answer - eraseCnt;
    }
}