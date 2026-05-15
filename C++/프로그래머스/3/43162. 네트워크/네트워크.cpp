#include <string>
#include <vector>

using namespace std;

/*
    네트워크의 수를 체크
    이건 DFS로 간선들을 이동하면서 ++해도 좋고, union-find 알고리즘을 사용해서도 가능
*/

int parent[201];

int find(int idx) {
    if (parent[idx] == idx) {
        return idx;
    }
    else {
        return parent[idx] = find(parent[idx]);
    }
}

void unionNodes (int a, int b) {
    a = find(a);
    b = find(b);
    
    if (a < b) {
        parent[b] = a;
    }
    else {
        parent[a] = b;
    }
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    
    for (int i = 0; i < 201; i++) {
        parent[i] = i;
    }
    
    for (int i = 0; i < computers.size(); i++) {
        for (int j = 0; j < computers[i].size(); j++) {
            if (computers[i][j] == 1) {
                unionNodes(i, j);
            }
        }
    }
    
    for (int i = 0; i < computers.size(); i++) {
        if (parent[i] == i) {
            answer++;
        }
    }
    
    return answer;
}