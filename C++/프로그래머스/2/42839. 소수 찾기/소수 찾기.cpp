#include <bits/stdc++.h>
using namespace std;

int n;
bool visited[8];
unordered_set<int> candidates;

void dfs(vector<char>& vec, string num) {
    if (!num.empty()) {
        candidates.insert(stoi(num));
    }

    for (int i = 0; i < n; i++) {
        if (visited[i]) continue;   // 이미 쓴 자리는 건너뛰기

        visited[i] = true;
        dfs(vec, num + vec[i]);
        visited[i] = false;         // 백트래킹: 원상복구
    }
}

bool isPrime(int num) {
    if (num < 2) return false;      // 0, 1은 소수 아님
    for (int i = 2; (long long)i * i <= num; i++) {
        if (num % i == 0) return false;
    }
    return true;
}

int solution(string numbers) {
    n = numbers.length();
    vector<char> vec;
    for (int i = 0; i < n; i++) {
        vec.push_back(numbers[i]);
    }

    fill(visited, visited + n, false);
    dfs(vec, "");

    int answer = 0;
    for (int num : candidates) {
        if (isPrime(num)) answer++;
    }

    return answer;
}