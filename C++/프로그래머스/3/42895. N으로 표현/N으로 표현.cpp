#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

int solution(int N, int number) {
    unordered_set<int> dp[9];
    string str = "";
    
    for (int i = 1; i < 9; i++) {
        str += to_string(N);
        dp[i].insert(stoi(str));
        
        for (int j = 1; j < i; j++) {
            for (int a : dp[j]) {
                for (int b : dp[i - j]) {
                    dp[i].insert(a + b);
                    dp[i].insert(a - b);
                    dp[i].insert(a * b);
                    if (b != 0) dp[i].insert(a / b);
                }
            }
        }
        
        if (dp[i].count(number) == 1) {
            return i;
        }
    }
    return -1;
}