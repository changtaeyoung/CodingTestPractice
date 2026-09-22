#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

/*
    모두 1로 동일하니, 다익스트라 이런 어려운 로직보다 BFS를 쓸 수 있다.
    
    노드를 사용하는 BFS를 사용하면 빠르게 풀 수 있을 것 같음. 다익스트라를 사용핻 되고.
    단, 길이 50만개라서 2중반복을 사용하는 BFS는 사용 못할 수도 있음
    일단 지역이 1베이스라서 n + 1로 생성해주어야 함.
*/


int bfs(int start, int end, const vector<vector<int>>& map, vector<bool> visited) {
    queue<pair<int, int>> q; // node idx, cost
    q.push({start, 0});
    visited[start] = true;
    
    while (!q.empty()) {
        pair<int, int> cur = q.front();
        q.pop();
        
        if (cur.first == end) return cur.second;
        
        for (int next : map[cur.first]) {
            if (!visited[next]) {
                visited[next] = true;
                q.push({next, cur.second + 1});
            }
        }
    }
    return -1;
}

vector<int> solution(int n, vector<vector<int>> roads, vector<int> sources, int destination) {
    vector<int> ans;
    vector<vector<int>> map(n + 1);
    vector<bool> visited(n + 1);
    
    for (int i = 0; i < roads.size(); i++) {
        map[roads[i][0]].push_back(roads[i][1]);
        map[roads[i][1]].push_back(roads[i][0]);
    }
    
    for (int i = 0; i < sources.size(); i++) {
        ans.push_back(bfs(sources[i], destination, map, visited));
    }
    
    return ans;
}