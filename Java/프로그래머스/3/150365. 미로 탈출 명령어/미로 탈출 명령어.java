class Solution {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static char[] str;
    static int depth;

    static boolean dfs(int ex, int ey, int sx, int sy, int tx, int ty, int dist) {

        if (depth == dist) {
            return sx == tx && sy == ty;
        }

        int manhattan = Math.abs(sx - tx) + Math.abs(sy - ty);
        int left = dist - depth;

        if (manhattan > left) return false;
        if ((left - manhattan) % 2 != 0) return false;  // 홀짝 가지치기

        for (int i = 0; i < 4; i++) {
            int nx = sx + dx[i];
            int ny = sy + dy[i];

            if (nx >= 1 && nx <= ex && ny >= 1 && ny <= ey) {
                str[depth] = i == 0 ? 'd' : i == 1 ? 'l' : i == 2 ? 'r' : 'u';
                depth++;
                if (dfs(ex, ey, nx, ny, tx, ty, dist)) return true;
                depth--;
            }
        }
        return false;
    }

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        str = new char[k];
        depth = 0;

        int manhattan = Math.abs(x - r) + Math.abs(y - c);
        if (manhattan > k || (k - manhattan) % 2 != 0) {
            return "impossible";
        }

        return dfs(n, m, x, y, r, c, k) ? String.valueOf(str) : "impossible";
    }
}