#include <string>
#include <vector>
#include <algorithm>

using namespace std;
/*
    s에서 시작해 a, b로 가야하는데 최소값을 사용해야함.
    s에서 i까지, i에서 a까지, i -> b까지 3구역으로 나눠서 풀어야하는 문제인가?
    3개 모두 최적으로 가기 위해선 4중 반복이 필요해보이는데 이러면 200개 테케에서 효율성이 매우 떨어질 거 같은데
*/

int dist[201][201];

int solution(int n, int s, int a, int b, vector<vector<int>> fares) {
    int answer = 0;
    
    for (int i = 0; i < n; i++) {
        fill(dist[i], dist[i] + n, 1e9);
        dist[i][i] = 0;
    }
    
    for (int i = 0; i < fares.size(); i++) {
        dist[fares[i][0] - 1][fares[i][1] - 1] = fares[i][2];
        dist[fares[i][1] - 1][fares[i][0] - 1] = fares[i][2];
    }
    
    for (int i = 0; i < n; i++) { // 중간 지점
        for (int j = 0; j < n; j++) { // 시작 지점
            for (int k = 0; k < n; k++) { // 끝 지점
                dist[j][k] = min(dist[j][k], dist[j][i] + dist[i][k]);
            }
        }
    }
    
    answer = dist[s - 1][a - 1] + dist[s - 1][b - 1]; // 일단 바로 가는 거 하나 적고
    for (int i = 0; i < n; i++) { // 중간 지점들을 계산해볼거임
        if (dist[s - 1][i] != 1e9 && dist[i][a - 1] != 1e9 && dist[i][b - 1] != 1e9) {
            int costSum = dist[s - 1][i] + dist[i][a - 1] + dist[i][b - 1];
            if (answer > costSum) {
                answer = costSum;
            }
        }
    }
    
    return answer;
}