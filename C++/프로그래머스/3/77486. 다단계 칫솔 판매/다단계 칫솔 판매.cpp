#include <string>
#include <vector>
#include <unordered_map>
#include <cmath>

using namespace std;

// 누가 누구와 연결되어있는지 작성할 map이 필요해보임.

vector<int> solution(vector<string> enroll, vector<string> referral, vector<string> seller, vector<int> amount) {
    unordered_map<string, string> tree; // tree를 이용하여 누가 누구와 연결되어있는지 확인
    unordered_map<string, int> idx;
    vector<int> ans (enroll.size(), 0); // enroll의 사이즈로 0 초기화
    
    for (int i = 0; i < enroll.size(); i++) {
        idx[enroll[i]] = i;
    }
    
    for (int i = 0; i < referral.size(); i++) {
        tree.insert({enroll[i], referral[i]});
    }
    
    for (int i = 0; i < seller.size(); i++) {
        int money = amount[i] * 100; // 판매 수익
        string next = seller[i];
        
        while (next != "-") {
            int give = money / 10;
            ans[idx[next]] += money - give;
            
            if (give < 1) break;
            
            money = give;
            next = tree[next];
        }
    }
    
    return ans;
}