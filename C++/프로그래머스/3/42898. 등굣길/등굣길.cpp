#include <string>
#include <vector>

using namespace std;

/*
    상단과 좌측에 0 padding 해놓으면 됨
*/

int map[101][101];
int dp[101][101];

int solution(int m, int n, vector<vector<int>> puddles) {
    int answer = 0;
    
    // 1이 웅덩이, 0이 길임
    for (int i = 0; i < puddles.size(); i++) {
        map[puddles[i][1]][puddles[i][0]] = 1;
    }
    
    dp[1][1] = 1;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (dp[i][j] == 0 && map[i][j] != 1) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
            }
        }
    }
    
    answer = dp[n][m];
    return answer;
}