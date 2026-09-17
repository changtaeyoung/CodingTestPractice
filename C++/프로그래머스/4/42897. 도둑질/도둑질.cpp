#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int robbing (const vector<int> & house_money, int start, int end) {
    int n = end - start;
    if (n == 0) return 0;
    if (n == 1) return house_money[start];
    
    vector<int> dp(n);
    dp[0] = house_money[start];
    dp[1] = max(house_money[start], house_money[start + 1]);
    
    for (int i = 2; i < n; i++) {
        dp[i] = max(dp[i - 1], dp[i - 2] + house_money[start + i]);
    }
    
    return dp[n - 1];
}

int solution(vector<int> money) {
    int cA = 0, cB = 0, n = money.size();
    
    if (n == 1) return money[0];
    
    // 케이스를 0에서 시작, 1에서 시작으로 분리하고 선형 DP를 2번 불러오도록 함
    cA = robbing(money, 0, n - 1);
    cB = robbing(money, 1, n);
    
    return max(cA, cB);
}