#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> stu1 = {1, 2, 3, 4, 5};
    vector<int> stu2 = {2, 1, 2, 3, 2, 4, 2, 5};
    vector<int> stu3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    vector<int> score(4, 0); 

    for (int i = 0; i < answers.size(); i++) {
        if (answers[i] == stu1[i % stu1.size()]) score[1]++;
        if (answers[i] == stu2[i % stu2.size()]) score[2]++;
        if (answers[i] == stu3[i % stu3.size()]) score[3]++;
    }

    int maxScore = max({score[1], score[2], score[3]});

    vector<int> ans;
    for (int i = 1; i <= 3; i++) {
        if (score[i] == maxScore) ans.push_back(i);
    }

    return ans;
}