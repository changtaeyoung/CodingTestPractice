#include <string>
#include <vector>
#include <queue>
#include <cmath>

using namespace std;

/*
    1시간 동안 작업량 1 처리
    N시간 동안 최소화
    야근 시작 시점, 남은 일의 작업량 제곱 후 합산
    
    즉, 예시를 따르면
    4 3 3의 작업량이 남아있는데, 4를 해서 2, 1, 1로 분배해서 일한다면 나머지가 2,2,2일테니 제곱 합산이 제일 작게 됨
    원소 배열은 2만이니까 2중 반복도 가능하긴 할 듯
    
    우선순위 큐를 만들어서 (최대힙)
    큰 값들 순으로 -1을 계속 해줌으로써 제곱수를 구해보는 것은 어떨까?
*/

priority_queue<int> pq;

long long solution(int n, vector<int> works) {
    long long answer = 0;
    long long sum = 0;
    
    for (int i = 0; i < works.size(); i++) {
        sum += works[i];
    }
    
    if (sum <= n) {
        answer = 0;
    }
    else {
        for (int i = 0; i < works.size(); i++) {
            pq.push(works[i]);
        }

        while (n > 0) {
            int nowWork = pq.top();
            pq.pop();
            nowWork--;
            pq.push(nowWork);
            n--;
        }

        while (!pq.empty()) {
            int now = pq.top();
            answer += pow(now, 2);
            pq.pop();
        }
    }
    return answer;
}