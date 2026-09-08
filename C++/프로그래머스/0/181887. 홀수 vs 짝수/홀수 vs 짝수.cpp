#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> num_list) {
    int sum_o = 0, sum_e = 0;
    
    for (int i = 0; i < num_list.size(); i++) {
        if (i % 2 == 0) {
            sum_o += num_list[i];
        }
        else {
            sum_e += num_list[i];
        }
    }
    
    return sum_o > sum_e ? sum_o : sum_e;
}