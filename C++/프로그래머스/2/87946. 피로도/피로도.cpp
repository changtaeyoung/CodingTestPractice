#include <string>
#include <vector>

using namespace std;

/*
    최소 필요 피로도, 소모 피로도
    이상, 소모
    
    모든 던전을 다 돌아다녀 보면서, 들어갈 수 있는 곳, 그리고 최다 던젼을 세면 될 것 같음
    DFS, BACKTRACKING
*/
int answer = 0;
bool visited[8];

void dfs (int health, const vector<vector<int>>& map, int cnt) {
    
    if (cnt > answer) {
        answer = cnt;
    }
    
    for (int i = 0; i < map.size(); i++) {
        if (health >= map[i][0]) { // 이래야지만 들어갈 수 있잖아
            if (!visited[i]) {
                visited[i] = true;
                cnt++;
                health -= map[i][1];
                dfs(health, map, cnt);
                visited[i] = false;
                cnt--;
                health += map[i][1];
            }
        }
    }
}

int solution(int k, vector<vector<int>> dungeons) {
    
    dfs(k, dungeons, 0);    
    return answer;
}