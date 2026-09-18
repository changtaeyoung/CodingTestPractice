#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = s.length();
    
    for (int i = 1; i <= s.length() / 2; i++) {
        string result = "";
        int cnt = 1;
        string prev = s.substr(0, i);
        
        for (int j = i; j < s.length(); j += i) {
            string cur = s.substr(j, i);
            
            if (prev == cur) {
                cnt++;
            }
            else {
                result += (cnt > 1 ? to_string(cnt) : "") + prev;
                prev = cur;
                cnt = 1;
            }
        }
        
        result += (cnt > 1 ? to_string(cnt) : "") + prev;
        
        if (result.length() < answer) {
            answer = result.length();
        }
    }
    return answer;
}