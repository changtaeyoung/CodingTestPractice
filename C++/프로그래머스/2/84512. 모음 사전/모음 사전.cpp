#include <string>
#include <vector>

using namespace std;

int answer = 0, cnt = -1;
string arr[5] = {"A", "E", "I", "O", "U"};

void dfs (string str, string target) {
    cnt++;
    
    if (str == target) {
        answer = cnt;
        return;
    }
    
    if (str.length() >= 5) {
        return;
    }
    
    for (int i = 0; i < 5; i++) {
        dfs(str + arr[i], target);
    }
}

int solution(string word) {
    dfs("", word);
    return answer;
}