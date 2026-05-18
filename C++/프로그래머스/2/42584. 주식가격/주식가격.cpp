#include <string>
#include <vector>
#include <stack>

using namespace std;

/*
    스택과 큐 동시에 가동한다고 가정하면,
    prices 배열을 돌아. stack에 넣게 될 텐데, top 에 있는 값보다 크면 push, 
    작으면 pop. 근데 여기서 값을 넣는게 아니라 인덱스를 넣게되면, answer에 넣는 것도 수월해지지 않을까? 싶긴함.
*/

vector<int> solution(vector<int> prices) {
    vector<int> answer(prices.size());
    stack<int> s; // index를 넣기
    
    for (int i = 0; i < prices.size(); i++) {
        
        while (!s.empty() && prices[s.top()] > prices[i]) {
            int nowIdx = s.top();
            s.pop();
            answer[nowIdx] = i - nowIdx;
        }
        s.push(i);
    }
    
    // 1 2 4 6 35 42 9 465 6 66 7 1100 52536    
    while (!s.empty()) {
        int now = s.top();
        answer[now] = prices.size() - 1 - now;
        s.pop();
    }
    
    return answer;
}