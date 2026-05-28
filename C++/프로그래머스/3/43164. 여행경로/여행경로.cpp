#include <string>
#include <vector>
#include <queue>
#include <iostream>
#include <algorithm>

using namespace std;

/*
    그냥 내가 첫번째 드는 생각은 공항들을 노드로 바꿔버리자라는 생각이야. 근데 어떻게 바꿀껀지도 의문인거지 사실.
    DFS를 이용해서 방문하는 공항 경로를 담아내야할테고
    
    그리고 노드로 안쓴다고 해도, DFS를 이용해서 다음 것으로 넘어가야할 때
    예시 2번처럼 2개의 경로가 있을 때 알파벳이 빠른 순으로 가야해.
    10000개 이상이니 2중 반복도 간당간당해보일 것 같고
    visited는 필요 없어보이는게 어차피 몇번 지나갈 수 있을 듯 함 -> 이걸 항공권 쓴 여부로 해야겠네
*/

vector<string> answer;
bool visited[10001];

bool isFind = false;
void dfs(string cur, int used, const vector<vector<string>>& tickets) {
    if (isFind) {
        return;
    }
    
    answer.push_back(cur);
    
    if (used == tickets.size()) {
        isFind = true;
        return;
    }
    
    for (int i = 0; i < tickets.size(); i++) {
        if (tickets[i][0] == cur && !visited[i]) {
            visited[i] = true;
            dfs (tickets[i][1], used + 1, tickets);
            
            if (isFind) {
                return;
            }
            visited[i] = false;
        }
    }
    answer.pop_back();
}

vector<string> solution(vector<vector<string>> tickets) {
    sort(tickets.begin(), tickets.end());
    dfs("ICN", 0, tickets);
    
    return answer;
}