#include <string>
#include <vector>
#include <algorithm>

using namespace std;

/*
    가장 처음 생각이 난 것, 거리는 10억. 매우 크기 때문에 이분 탐색을 생각해볼 수 있음
    각 바위 사이 거리가 대충 나와있으므로 정렬시키고.
    
    뭐로 이분 탐색을 하느냐인데. 
    거리로 정렬하면 뭐 안될 거 같은데. (0 ~ distance)
    바위의 개수도 아니고.
    
    0 -> distance 까지. n개의 돌을 부술 수 있어.
    
    잠깐의 힌트를 보고 알았는데, (전에 작성했던 코드를 이용해서)
    minL, maxL을 구하고 averL동안의 바위를 부숴. 
    그리고 n보다 많은 바위를 부쉈다면 더 큰 값으로, 반대는 작은 값으로 이동
    가장 큰 값을 구하는 거니까 큰 값으로 이동할 때 ans에 답을 기록해두면 될 거 같음.
*/

bool isValid (const vector<int> & rockArr, int rlen, int n, int dist) {
    int lastIdx = 0, cnt = 0;
    for (int i = 0; i < rockArr.size(); i++) {
        if (rockArr[i] - lastIdx < rlen) {
            cnt++;
        }
        else {
            lastIdx = rockArr[i];
        }
    }
    
    if (dist - lastIdx < rlen) cnt++;
    
    return cnt <= n;
}

int solution(int distance, vector<int> rocks, int n) {
    
    sort(rocks.begin(), rocks.end());
    int minL = 1, maxL = 1e9, ans = 0;
    
    while (minL <= maxL) {
        int averL = (minL + maxL) / 2;
        
        if (isValid(rocks, averL, n, distance)) {
            ans = averL;
            minL = averL + 1;
        }
        else {
            maxL = averL - 1;
        }
    }
    
    return ans;
}