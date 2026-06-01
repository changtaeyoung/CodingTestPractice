import java.util.*;

class Solution {
    
    static int[] parent;
    
    static int find (int n) {
        if (parent[n] == n) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }
    
    static void unionNodes (int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a < b) {
            parent[b] = a;
        }
        else {
            parent[a] = b;
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        parent = new int[200];
        for (int i = 0; i < 200; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (computers[i][j] == 1) {
                    unionNodes(i, j);
                }
            }
        }
        
        for (int i = 0; i < computers.length; i++) {
            if (parent[i] == i) {
                answer++;
            }
        }
        
        return answer;
    }
}