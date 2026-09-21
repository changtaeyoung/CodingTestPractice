#include <string>
#include <vector>
using namespace std;

int solution(int m, int n, vector<string> board) {
    int ans = 0;

    while (true) {
        vector<vector<bool>> toErase(board.size(), vector<bool>(board[0].length(), false));
        bool found = false;

        // 제거할 후보군 찾기 — 좌표를 vector에 쌓지 않고, 마킹만 함
        for (int i = 0; i < board.size() - 1; i++) {
            for (int j = 0; j < board[i].length() - 1; j++) {
                if (board[i][j] != ' '
                    && board[i][j] == board[i + 1][j]
                    && board[i][j] == board[i][j + 1]
                    && board[i][j] == board[i + 1][j + 1]) {
                    toErase[i][j] = true;
                    toErase[i + 1][j] = true;
                    toErase[i][j + 1] = true;
                    toErase[i + 1][j + 1] = true;
                    found = true;
                }
            }
        }

        if (!found) break;

        // 제거
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (toErase[i][j]) {
                    board[i][j] = ' ';
                    ans++;
                }
            }
        }

        // 내림
        for (int j = 0; j < board[0].length(); j++) {
            int idx = board.size() - 1;
            for (int i = board.size() - 1; i >= 0; i--) {
                if (board[i][j] != ' ') {
                    board[idx][j] = board[i][j];
                    idx--;
                }
            }
            while (idx >= 0) {
                board[idx][j] = ' ';
                idx--;
            }
        }
    }

    return ans;
}