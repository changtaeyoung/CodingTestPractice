#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

/*
    정사각형은 가로와 세로의 길이가 동일해야함. 
    즉, 좌, 상단이 1이고 대각선 전이 1일 경우, 길이가 +1이 된 정사각형을 찾을 수 있음
    
    아니면 2차원 배열을 이용해서 현 좌표에서는 이 값이 최댓값이다라는 느낌으로
*/

int solution(vector<vector<int>> board)
{
    int ans = 0;
    int dp[1001][1001] = {0}; // dp에는 좌표에 있는 곳에서 한변의 최대 길이가 된다.
    
    for (int i = 0; i < board.size(); i++) {
        for (int j = 0; j < board[i].size(); j++) {
            if (board[i][j] == 1) dp[i][j] = 1;
        }
    }
    
    for (int i = 0; i < board.size(); i++) {
        for (int j = 0; j < board[i].size(); j++) {
            if (i == 0 || j == 0) { // 어차피 얘네는 넓이가 1인 애들일테니
                continue;
            }
            else {
                if (board[i][j] == 1) {
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]);    
                    dp[i][j] = min(dp[i][j], dp[i - 1][j - 1]) + 1;
                }   
            }
        }
    }
    
    for (int i = 0; i < board.size(); i++) {
        for (int j = 0; j < board[i].size(); j++) {
            if (ans < dp[i][j]) {
                ans = dp[i][j];
            }
        }
    }
    
    return ans*ans;
}