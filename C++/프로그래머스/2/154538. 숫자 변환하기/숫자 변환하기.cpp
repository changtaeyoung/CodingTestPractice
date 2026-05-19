#include <string>
#include <vector>
#include <queue>

using namespace std;

/*
    최소 연산이기 때문에, y라는 값에 최대한 빨리 근접해야해.
    그렇다면, x에 3배를 했을 때, y보다 커지면 더이상 하지 못하게 하고,
    그다음 2배 그다음 +n을 해야하지 않을까 싶은데?
    
    근데 그러면 
*/
int visited[1000001];

void bfs(int s, int t, int n) {
    queue<int> q;
    q.push(s);
    visited[s] = 1;
    
    while (!q.empty()) {
        int c = q.front();
        if (c == t) {
            return;
        }
        q.pop();
        
        if (c * 3 <= t) {
            if (!visited[c * 3]) {
                visited[c * 3] = visited[c] + 1;
                q.push(c * 3);
            }
        }
        
        if (c * 2 <= t) {
            if (!visited[c * 2]) {
                visited[c * 2] = visited[c] + 1;
                q.push(c * 2);
            }
        }
        
        if (c + n <= t) {
            if (!visited[c + n]) {
                visited[c + n] = visited[c] + 1;
                q.push(c + n);
            }
        }
    }
}

int solution(int x, int y, int n) {
    bfs(x, y, n);
    
    return visited[y] - 1;
}