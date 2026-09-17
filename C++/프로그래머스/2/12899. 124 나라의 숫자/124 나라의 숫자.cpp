#include <string>
#include <vector>

using namespace std;

// 3진법과 비슷한 느낌임.

string num[3] = {"4", "1", "2"};

string solution(int n) {
    string ans = "";
    
    while (n > 0) {
        ans.insert(0, num[n % 3]); 
        n = (n - 1) / 3;
    }
    
    return ans;
}