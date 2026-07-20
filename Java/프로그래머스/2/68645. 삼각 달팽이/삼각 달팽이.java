import java.util.*;

class Solution {
    /*
        1차 시도: List<List<Integer>>를 사용하려 했지만 생각해보니, 중간에 숫자가 들어가야하기 때문에 안된다.
        
        2차 : dx, dy로 변화하는 좌표를 만들어서.. 근데 -1 out of bounds. 이게 맞는 거 같긴 한데.
        
        
    */
    
    
    public int[] solution(int n) {
        int[][] map = new int[n][n]; // n * n의 맵이 만들어짐.
        
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        
        int sx = 0, sy = 0, dir = 0;
        for (int i = 1; i <= (n * (n + 1)) / 2; i++) { // 1. 저장하고 2. 위치 변환
            map[sx][sy] = i;
            
            int nx = sx + dx[dir % 3];
            int ny = sy + dy[dir % 3];
            
            if (nx >= n || ny >= n || nx < 0 || ny < 0 || map[nx][ny] != 0) {
                dir += 1;
                // nx, ny 올바른 방향값으로 덮어씌우기 
                nx = sx + dx[dir % 3]; 
                ny = sy + dy[dir % 3];
            } 
            
            sx = nx;
            sy = ny;
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) { // why? 앞에서 모두 채웠을 텐데 0을 만난 이후로는 값이 없을테니까
                    break;
                }
                ans.add(map[i][j]);
            }
        }
        
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}