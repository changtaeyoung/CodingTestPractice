#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

/*
    10000대 이하
    최소 대수를 구해야함
    최소! DP, BFS, Greedy 등..
    BFS는 당연히 아니고, DP, Greedy일 듯 한데...

    -20,-15
    -18,-13
    -14,-5
    -5,-3
*/

bool compare (vector<int> v1, vector<int> v2) {
    if (v1[1] < v2[1]) {
        return true;
    }
    return false;
}

int solution(vector<vector<int>> routes) {
    int answer = 0, cmIdx = -999999;
    
    sort(routes.begin(), routes.end(), compare);
    
    cmIdx = routes[0][1];
    answer++;
    for (int i = 0; i < routes.size(); i++) {
        if (cmIdx < routes[i][0]) { // cmIdx 카메라 설치한 곳보다 시작점이 멀리있을 경우
            cmIdx = routes[i][1];
            answer++;
        }
        
    } 
    return answer;
}