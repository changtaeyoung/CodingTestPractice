#include <string>
#include <vector>
#include <stack>

using namespace std;

/*
    1,2,3,4.. 이런식으로 값이 들어오고
    만약 원하는 order의 순서가 아니라면 stack에 집어 넣어야지.
    
    stack에 넣고 빼는 기준을 정해야할 듯 함
    수를 하나씩 넣는데, 
*/

int solution(vector<int> order) {
    int answer = 0, idx = 0;
    stack<int> s;
    
    for (int i = 1; i <= order.size() ; i++) {
        s.push(i);
        
        while (!s.empty()) {
            if (s.top() == order[idx]) {
                idx++;
                answer++;
                s.pop();
            }
            else {
                break;
            }
        }
        
    }
    
    return answer;
}