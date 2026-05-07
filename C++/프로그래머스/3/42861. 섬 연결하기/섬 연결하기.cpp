#include <string>
#include <vector>
#include <algorithm>

using namespace std;
/*
    0과 1에는 연결되는 두 섬의 번호, 2에는 건설할 때 드는 비용
    노드들처럼 느껴지고, 최소 비용으로 통행한다? 간선의 최소비용? 그러면 대부분 크루스칼이다.
*/

int parent[101];
vector<pair<int, pair<int, int>>> edges;

int find (int n) {
    if(parent[n] == n) {
        return n;
    }
    return parent[n] = find(parent[n]);
}

void unionNodes(int n1, int n2) {
    n1 = find(n1);
    n2 = find(n2);
    
    if (n1 < n2) {
        parent[n2] = n1;
    }
    else {
        parent[n1] = n2;
    }
}

int solution(int n, vector<vector<int>> costs) {
    int answer = 0;
    for (int i = 0; i < 101; i++) {
        parent[i] = i;
    }
    
    for (int i = 0; i < costs.size(); i++) {
        edges.push_back({costs[i][2], {costs[i][0], costs[i][1]}});
    }
    sort(edges.begin(), edges.end());
    
    for (const auto& edge : edges) {
        if (find(edge.second.first) != find(edge.second.second)) {
            unionNodes(edge.second.first, edge.second.second);
            answer += edge.first;
        }
    }
    
    return answer;
}