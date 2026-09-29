import java.util.*;
/*
    이 문제에 대해서
    좌표 평면을 만들고
    그냥 명령어를 따라가되, 현재 위치가 visited이고, 다음 위치가 visited면 세지 않는다 -> 틀림.
    ㄷ자 형태로 갔었고 ㅁ자가 되기 위해 위든 아래든 이동할 때 그럼 세지 않게 되니까.
    
    결국 지나간 간선을 어떻게 저장할 것이냐가 제일 키 포인트인데
    현재 위치에서 사용한 방향을 기억한다? -> 예를 들어, 2차원 평면이니까 3차원으로 확장해서 4개의 원소를 쓴다?
*/

class Solution {
    
    // 우, 좌, 하, 상
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0 ,0};
    static boolean[][][] visited;
    
    public int solution(String dirs) {
        visited = new boolean[11][11][5]; // x, y, 방향(1,2,3,4가 방향이고 0은 그냥 기존 시작 지점이라)
        
        int[][] map = new int[11][11]; // 좌표평면 만들기
        int cx = 5, cy = 5, cnt = 0;
        visited[cx][cy][0] = true;
        
        for (char c : dirs.toCharArray()) {
            if (c == 'R') {
                int nx = cx + dx[0];
                int ny = cy + dy[0];
                
                if (nx >= 0 && nx < 11 && ny >= 0 && ny < 11) { // 안에 있는지 판단
                    // 다음 지점이 안에 있다면 이동
                    if (!visited[cx][cy][1]) cnt++; // 전 위치에서 1로 이동하는 간선을 사용하지 않았다면
                    visited[cx][cy][1] = true; // 전 지점에서의 우측 이동
                    visited[nx][ny][2] = true; // 현 지점에서의 좌측 이동
                    cx = nx;
                    cy = ny;
                }
                else { // n로 미리 판단해놓은 것이기 때문에 실제 위치한 c는 건드리지 않음
                    continue;
                }
            }
            else if (c == 'L') {
                int nx = cx + dx[1];
                int ny = cy + dy[1];
                
                if (nx >= 0 && nx < 11 && ny >= 0 && ny < 11) { // 안에 있는지 판단
                    // 다음 지점이 안에 있다면 이동
                    if (!visited[cx][cy][2]) cnt++; // 전 위치에서 1로 이동하는 간선을 사용하지 않았다면
                    visited[cx][cy][2] = true; // 전 지점에서의 우측 이동
                    visited[nx][ny][1] = true; // 현 지점에서의 좌측 이동
                    cx = nx;
                    cy = ny;
                }
                else { // n로 미리 판단해놓은 것이기 때문에 실제 위치한 c는 건드리지 않음
                    continue;
                }
            }
            else if (c == 'D') {
                int nx = cx + dx[2];
                int ny = cy + dy[2];
                
                if (nx >= 0 && nx < 11 && ny >= 0 && ny < 11) { // 안에 있는지 판단
                    // 다음 지점이 안에 있다면 이동
                    if (!visited[cx][cy][3]) cnt++; // 전 위치에서 1로 이동하는 간선을 사용하지 않았다면
                    visited[cx][cy][3] = true; // 전 지점에서의 우측 이동
                    visited[nx][ny][4] = true; // 현 지점에서의 좌측 이동
                    cx = nx;
                    cy = ny;
                }
                else { // n로 미리 판단해놓은 것이기 때문에 실제 위치한 c는 건드리지 않음
                    continue;
                }
            }
            else if (c == 'U') {
                int nx = cx + dx[3];
                int ny = cy + dy[3];
                
                if (nx >= 0 && nx < 11 && ny >= 0 && ny < 11) { // 안에 있는지 판단
                    // 다음 지점이 안에 있다면 이동
                    if (!visited[cx][cy][4]) cnt++; // 전 위치에서 1로 이동하는 간선을 사용하지 않았다면
                    visited[cx][cy][4] = true; // 전 지점에서의 우측 이동
                    visited[nx][ny][3] = true; // 현 지점에서의 좌측 이동
                    cx = nx;
                    cy = ny;
                }
                else { // n로 미리 판단해놓은 것이기 때문에 실제 위치한 c는 건드리지 않음
                    continue;
                }
            }
        }
        
        return cnt;
    }
}