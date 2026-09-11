#include <string>
#include <vector>
#include <algorithm>

using namespace std;

/*
    탑다운 방식, 바텀업 방식이 존재하나, 가장 무난한 탑다운 방식을 적용해보겠음
*/

int solution(vector<vector<int>> triangle) {
    int dp[501][501], n = triangle.size(), ans = 0;
    dp[0][0] = triangle[0][0];
    
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < triangle[i].size(); j++) {
            if (j == 0) {
                dp[i][j] = dp[i - 1][j] + triangle[i][j];
            }
            else if (j == triangle[i].size() - 1) {
                dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
            }
            else {
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
            }
        }
    }
    
    for (int i = 0; i < n; i++) {
        if (ans < dp[n - 1][i]) {
            ans = dp[n - 1][i];
        }
    }
    
    return ans;
}