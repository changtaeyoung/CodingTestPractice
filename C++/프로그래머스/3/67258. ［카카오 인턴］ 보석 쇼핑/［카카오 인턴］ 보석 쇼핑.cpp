#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

/*
    left, right라는 변수를 두고, 초반에는 right를 계속 늘려, 그다음에 set의 size가 4개라면 left를 올려
    그러면 되지 않을까?
*/

vector<int> solution(vector<string> gems) {
    int left = 0, right = 0;
    unordered_map<string, int> gemset;
    unordered_map<string, int> buyingGems;
    int ansL = 0, ansR = 1e9;
    
    for (int i = 0; i < gems.size(); i++) {
        gemset[gems[i]]++;
    }
    
    while (right < gems.size()) {
        buyingGems[gems[right]]++;
        right++;
        
        while (left < right && buyingGems.size() == gemset.size()) { // 어느 순간 모든 보석이 다 들어왔을 경우
            if (ansR - ansL > right - left) { // 현재까지 진행됐던 구간의 길이가 가장 짧은 것인가? 확인.
                ansR = right;
                ansL = left;
            }
            
            buyingGems[gems[left]]--; // 좌측 포인터 보석 제거
            
            if (buyingGems[gems[left]] == 0) { // 좌측 포인터 보석 사라진다면 제거
                buyingGems.erase(gems[left]); 
            }
            
            left++; // 좌측 포인터 우측 이동
        }
    }
    
    vector<int> ans; // 2개 다 1 base로 바꿔야하니까
    ans.push_back(ansL + 1);
    ans.push_back(ansR);
    return ans;
}