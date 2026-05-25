#include <string>
#include <vector>

using namespace std;
/*
    타일 세우는 방식은 2가지. 
    1을 먹는 방식과 2를 먹는 방식이 있음.
    따라서, i번째 위치에서는 i-1번째에서 그리고 i - 2번째에서 오는 방식이 존재함
    그 두개를 더하면 되지 않을까 싶음.
    
*/

int dp[60001];

int solution(int n) {
    int answer = 0;
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    
    for (int i = 3; i <= n; i++) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
    }
    
    
    return dp[n];
}