#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool compare (int a, int b) {
    return a > b;
}

int solution(vector<int> people, int limit) {
    int boats = 0, big = 0, small = people.size() - 1;
    sort(people.begin(), people.end(), compare); // 내림차순 정렬
    
    while (big <= small) {
        if (people[big] + people[small] > limit) {
            boats++;
            big++;
        }
        else {
            boats++;
            big++;
            small--;
        }
    }
    
    return boats;
}