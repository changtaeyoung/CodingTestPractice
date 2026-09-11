#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int parent[101];
vector<tuple<int, int, int>> edges;

int find(int n) {
    if (parent[n] == n) {
        return n;
    }
    return parent[n] = find(parent[n]);
}

void unionNodes (int no1, int no2) {
    int n1 = find(no1);
    int n2 = find(no2);
    
    if (n1 > n2) {
        parent[n1] = n2;
    }
    else {
        parent[n2] = n1;
    }
}

int solution(int n, vector<vector<int>> costs) {
    int answer = 0;
    for (int i = 0; i <= n; i++) {
        parent[i] = i;
    }
    
    for (int i = 0; i < costs.size(); i++) {
        edges.push_back({costs[i][2], costs[i][0], costs[i][1]});
    }
    sort(edges.begin(), edges.end());
    
    for (const auto& e : edges) {
        auto [cost, a, b] = e;
        if (find(a) != find(b)) {
            unionNodes(a, b);
            answer += cost;
        }
    }
    
    return answer;
}