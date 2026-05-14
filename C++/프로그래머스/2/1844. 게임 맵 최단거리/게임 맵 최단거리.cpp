#include<vector>
#include <queue>
#include <algorithm>

using namespace std;

int n, m;
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

int visited[101][101];

void bfs (int sx, int sy, const vector<vector<int>>& map) {
    queue<pair<int, int>> q;
    visited[sx][sy] = 1;
    q.push({sx, sy});
    
    while (!q.empty()) {
        int cx = q.front().first;
        int cy = q.front().second;
        q.pop();
        
        if (cx == n - 1 && cy == m - 1) {
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (!visited[nx][ny] && map[nx][ny] != 0) {
                    q.push({nx, ny});
                    visited[nx][ny] = visited[cx][cy] + 1;
                }
            }
        }
    }
}

int solution(vector<vector<int> > maps)
{
    int answer = 0;
    n = maps.size();
    m = maps[0].size();
    
    bfs (0, 0, maps);
    
    answer = visited[n - 1][m - 1];
    if (answer == 0) {
        return -1;
    }
    return answer;
}