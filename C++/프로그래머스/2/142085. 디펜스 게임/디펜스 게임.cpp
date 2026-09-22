#include <string>
#include <vector>
#include <queue>

using namespace std;

/*
    일단 n은 10억으로 이렇게 큰 숫자가 온다면 이분 탐색을 의심해보아야 함. 
    enemy 배열의 크기도 그렇고. 100만이라서.
    
    enemy의 배열을 변경하면 안되니, 정렬도 못시키는데. 그러면 순서대로 계속 막고, PQ에 큰 순서대로 저장한 다음에
    PQ에 대해서 큰 거 막고 K 감소 시키면 되지 않나? 라는 생각.
*/

int solution(int n, int k, vector<int> enemy) {
    if (k >= enemy.size()) return enemy.size();
    
    priority_queue<int> pq; // pq는 c++에서는 자동으로 최대힙
    
    for (int i = 0; i < enemy.size(); i++) {
        n -= enemy[i]; 
        pq.push(enemy[i]);
        
        while (n < 0 && !pq.empty() && k > 0) { 
            n += pq.top();
            pq.pop();
            k--;
        }
        
        if (n < 0) {
            return i;
        }
    }
    
    return enemy.size();
}