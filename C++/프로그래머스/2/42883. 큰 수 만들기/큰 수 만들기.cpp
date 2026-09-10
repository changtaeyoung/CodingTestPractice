#include <string>
#include <vector>

using namespace std;

string solution(string number, int k) {
    string ans = "";
    
    for (char c : number) {
        while (!ans.empty() && ans.back() < c && k > 0) {
            ans.pop_back();
            k--;
        }
        
        ans.push_back(c);
    }
    
    if (k > 0) {
        ans = ans.substr(0, ans.length() - k);
    }
    
    return ans;
}