#include <string>
#include <vector>
#include <map>
#include <algorithm>
#include <iostream>

using namespace std;

/*
    스테이지에 도달했으나 클리어 못한 플레이어 수
    스테이지에 도달한 플레이어 수
    N이 스테이지의 개수인데, N+1의 수가 오면 모두 클리어한 사람임
    
    도전중인 플레이어수는 구했어. 
    지금의 문제. 도달한 플레이어의 수를 어떻게 구할것인가?
*/

map<int, int> challenge; // stage, cur players
map<int, int> reach; // stage, reached player
vector<pair<double, int>> failure;

bool compare(pair<double, int>& p1, pair<double, int>& p2) {
    if (p1.first > p2.first) {
        return true;
    }
    else if (p1.first == p2.first) {
        if (p1.second < p2.second) {
            return true;
        }
    }
    return false;
}

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    
    for (int i = 0; i < stages.size(); i++) {
        for (int j = 1; j <= N; j++) {
            if (stages[i] >= j) {
                reach[j]++;
                if (stages[i] == j) {
                    challenge[j]++;
                }
            }
        }
    }
    
    for (int i = 1; i <= N; i++) {
        if (reach.find(i) != reach.end()) {
            double prob = (double)challenge[i] / reach[i];
            failure.push_back({prob, i});
        }
        else {
            failure.push_back({0, i});
        }
    }
    
    sort(failure.begin(), failure.end(), compare);
    
    for (int i = 0; i < failure.size(); i++) {
        answer.push_back(failure[i].second);
    }

    return answer;
}