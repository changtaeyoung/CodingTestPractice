#include <string>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;

int students[31];

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    fill(students, students + n + 1, 1);
    
    for (int i = 0; i < lost.size(); i++) {
        students[lost[i]] -= 1;
    }
    
    for (int i = 0; i < reserve.size(); i++) {
        students[reserve[i]] += 1;
    }
    
    for (int i = 1; i <= n; i++) {
        if (students[i] == 0) {
            if (students[i - 1] > 1) {
                students[i - 1]--;
                students[i]++;
            }
            else if (students[i + 1] > 1) {
                students[i + 1]--;
                students[i]++;
            }
        }
    }
    
    for (int i = 1; i <= n; i++) {
        if (students[i] >= 1) {
            answer++;
        }
    }
    return answer;
}