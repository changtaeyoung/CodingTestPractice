#include <string>
using namespace std;

int solution(string name) {
    int answer = 0;
    int n = name.length();

    // 1. 상하 이동
    for (char c : name) {
        answer += min(c - 'A', 'Z' - c + 1);
    }

    // 2. 좌우 이동
    int minMove = n - 1; // 기본값: 그냥 한 방향으로 쭉

    for (int i = 0; i < n; i++) {
        int next = i + 1;
        while (next < n && name[next] == 'A') {
            next++;
        }

        int front = i;          // 앞쪽(0~i)을 오른쪽으로 가는 비용
        int back = n - next;    // 뒤쪽(next~끝)을 왼쪽 순간이동으로 가는 비용

        int candidate = front + back + min(front, back);
        minMove = min(minMove, candidate);
    }

    return answer + minMove;
}