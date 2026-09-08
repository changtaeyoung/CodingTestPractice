#include <bits/stdc++.h>

using namespace std;

/*
    긴거는 뒤로, 짧은 쪽을 앞으로..
*/

int solution(vector<vector<int>> sizes) {
    
    for (int i = 0; i < sizes.size(); i++) {
        sort(sizes[i].begin(), sizes[i].end());
    }
    
    int maxL = 0, maxW = 0;
    
    for (int i = 0; i < sizes.size(); i++) {
        if (sizes[i][0] > maxL) {
            maxL = sizes[i][0];
        }
        
        if (sizes[i][1] > maxW) {
            maxW = sizes[i][1];
        }
    }
    
    return maxL * maxW;
}