#include <string>
#include <vector>
#include <algorithm>

using namespace std;

/*
    숫자가 큰 쪽 승리, victory: 1, defeat: 0
    같으면 둘 다 승점 X
    A는 이미 고정.
    이를 보고 B의 최대 승점을 구해야함
    
    순서와 상관 없이 최대 승점을 얻게되는 경우인 문제.
    
*/

int solution(vector<int> A, vector<int> B) {
    int answer = 0;
    
    sort(A.begin(), A.end());
    sort(B.begin(), B.end());
    
    int idx = 0;
    
    for (int i = 0; i < B.size(); i++) {
        if (B[i] > A[idx]) {
            answer++;
            idx++;
        }
    }
    
    
    return answer;
}