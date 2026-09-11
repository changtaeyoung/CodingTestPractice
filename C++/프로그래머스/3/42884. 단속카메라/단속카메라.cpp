#include <string>
#include <vector>
#include <algorithm>

using namespace std;

/*
    이런 문제는 앞을 정렬해야할지, 뒤를 기준으로 정렬해야할지가 나뉜다.
    끝나는 지점에 하나씩 단속카메라를 넣으면 최소 개수가 가능할 것으로 보임
*/

int solution(vector<vector<int>> routes) {
    
    sort(routes.begin(), routes.end(), [](vector<int> v1, vector<int> v2) {
        if (v1[1] == v2[1]) {
            return v1[0] < v2[0];
        }
        return v1[1] < v2[1];
    }); // 뒷 원소를 기준으로 오름차순 정렬, 뒤 원소가 같다면 첫번째 원소로 정렬
    
    int idx = routes[0][1], ans = 1;
    for (int i = 1; i < routes.size(); i++) {
        if (idx < routes[i][0]) {
            idx = routes[i][1];
            ans++;
        }
    }
    
    return ans;
}