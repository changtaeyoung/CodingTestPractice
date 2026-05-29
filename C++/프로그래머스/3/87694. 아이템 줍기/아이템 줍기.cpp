#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

/*
    결국 캐릭터가 최소로 움직여서 아이템을 먹을 수 있는 곳으로 가야하는데
    BFS일텐데, 테두리를 어떻게 구하는지가 관건일 듯 함.
    BFS가 결국 큐를 이용하는데, 여기서 큐를 어떻게 이용해야할까?
    상하좌우로 움직인다 가정하고, 직사각형 내를 침입하지 않는 선에서 이용해야할듯?
    직사각형 넓이에 있는 애들을 다 +1씩 해버린다면, 나머지는 2가되고 3이 되던가 0이 되겠지?
    그럼 무조건 1만을 따라갈 수 있게 되잖아.
*/

int map[102][102];
int visited[102][102];

int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};

void bfs (int sx, int sy, int ix, int iy) {
    queue<pair<int, int>> q;
    q.push({sx, sy});
    visited[sx][sy] = 1;
    
    while(!q.empty()) {
        int cx = q.front().first;
        int cy = q.front().second;
        
        if (cx == ix && cy == iy) {
            return;
        }
        
        q.pop();
        
        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (nx >= 0 && nx <= 100 && ny >= 0 && ny <= 100 && !visited[nx][ny]) {
                if (map[nx][ny] == 1) {
                    visited[nx][ny] = visited[cx][cy] + 1;
                    q.push({nx, ny});
                }
            }
        }
    }
}

int solution(vector<vector<int>> rectangle, int characterX, int characterY, int itemX, int itemY) {
    int answer = 0;
    
    // 이렇게 되면 2중에서도 구분을 해야하는데 구분을 어케할건데? 교차점인지 아니면 직사각형 내부인지?
    // 교차점은 상하좌우 어느 한곳은 무조건 1이긴 한듯..?
    for (int i = 0; i < rectangle.size(); i++) {
        int sx = 2 * rectangle[i][0], sy = 2 * rectangle[i][1];
        int ex = 2 * rectangle[i][2], ey = 2 * rectangle[i][3];
        
        for (int j = sx; j <= ex; j++) {
            for (int k = sy; k <= ey; k++) {
                // 사각형의 완전한 내부인 경우 (가장자리 아님)
                if (j > sx && j < ex && k > sy && k < ey) {
                    map[j][k] = 2; // 다른 사각형의 테두리(1)와 겹치더라도 2로 덮어버림
                }
                // 사각형의 테두리인 경우
                else {
                    // 이미 다른 사각형의 내부(2)로 칠해진 곳이 아닐 때만 1을 유지
                    if (map[j][k] != 2) {
                        map[j][k] = 1;
                    }
                }
            }
        }
    }
    bfs (2 * characterX, 2 * characterY, 2 * itemX, 2 * itemY);
    
    answer = visited[2 * itemX][2 * itemY] / 2;
    return answer;
}