#include <string>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;

/*
    A > B -> A는 B를 항상 이긴다.
    결과를 가지고 선수들의 순위를 매긴다.
    주어지는 것은 1base, 내가 하는 것은 0base
    I - INF, w - win, l - lose
      0 1 2 3 4
    0 0 w
    1 l 0 l   w
    2   w 0 l
    3   w w 0
    4         0
*/

int ranking[101][101];

int solution(int n, vector<vector<int>> results) {
    int answer = 0;
    
    for (int i = 0; i < n; i++) {
        fill(ranking[i], ranking[i] + n, 1e9);
        ranking[i][i] = 0;
    }
    
    for (int i = 0; i < results.size(); i++) {
        ranking[results[i][0] - 1][results[i][1] - 1] = 1;
    }
    
    for (int i = 0; i < n; i++) { // 거쳐간 사람
        for (int j = 0; j < n; j++) { // 시작
            for (int k = 0; k < n; k++) { // 끝
                ranking[j][k] = min(ranking[j][k], ranking[j][i] + ranking[i][k]);
            }
        }
    }
    
    for (int i = 0; i < n; i++) {
        int cnt = 0;
        for (int j = 0; j < n; j++) {
            if (i != j) {
                if (ranking[i][j] != 1e9 || ranking[j][i] != 1e9) {
                    cnt++;
                }
            }
        }
        
        if (cnt == n - 1) {
            answer++;
        }
    }
    
    return answer;
}