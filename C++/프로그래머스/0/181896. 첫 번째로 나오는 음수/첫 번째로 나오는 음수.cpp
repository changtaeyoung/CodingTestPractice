#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> num_list) {
    int ans = -1;
    
    for (int i = 0; i < num_list.size(); i++) {
        if (num_list[i] < 0) {
            ans = i;
            break;
        }
    }
    
    return ans;
}