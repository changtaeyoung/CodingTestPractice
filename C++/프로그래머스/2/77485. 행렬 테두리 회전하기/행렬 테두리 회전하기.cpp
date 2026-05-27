#include <string>
#include <vector>
#include <deque>

using namespace std;

/*
    라인의 값만 추출해서 덱을 만들고, 한칸씩 뒤로 미뤄.
    그다음에 순서대로 다시 집어넣으면 끝
    덱에서도 그냥 최소 숫자 찾으면 됨
*/

int map[101][101];

vector<int> solution(int rows, int columns, vector<vector<int>> queries) {
    vector<int> answer;
    
    int num = 1;
    for (int i = 1; i <= rows; i++) { // 1base
        for (int j = 1; j <= columns; j++) { // 1base
            map[i][j] = num;
            num++;
        }
    }
    
    for (int i = 0; i < queries.size(); i++) {
        deque<int> tmp;
        int sx = queries[i][0], sy = queries[i][1];
        int ex = queries[i][2], ey = queries[i][3];
        int min = 1e9;
        
        for (int i = sy; i < ey; i++) {
            tmp.push_back(map[sx][i]);
            if (min > map[sx][i]) {
                min = map[sx][i];
            }
        }
        for (int i = sx; i < ex; i++) {
            tmp.push_back(map[i][ey]);
            if (min > map[i][ey]) {
                min = map[i][ey];
            }
        }
        for (int i = ey; i > sy; i--) {
            tmp.push_back(map[ex][i]);
            if (min > map[ex][i]) {
                min = map[ex][i];
            }
        }
        for (int i = ex; i > sx; i--) {
            tmp.push_back(map[i][sy]);
            if (min > map[i][sy]) {
                min = map[i][sy];
            }
        }
        
        answer.push_back(min);
        
        tmp.push_front(tmp.back());
        tmp.pop_back();
        
        for (int i = sy; i < ey; i++) {
            map[sx][i] = tmp.front();
            tmp.pop_front();
        }
        for (int i = sx; i < ex; i++) {
            map[i][ey] = tmp.front();
            tmp.pop_front();
        }
        for (int i = ey; i > sy; i--) {
            map[ex][i] = tmp.front();
            tmp.pop_front();
        }
        for (int i = ex; i > sx; i--) {
            map[i][sy] = tmp.front();
            tmp.pop_front();
        }
    }
    
    return answer;
}