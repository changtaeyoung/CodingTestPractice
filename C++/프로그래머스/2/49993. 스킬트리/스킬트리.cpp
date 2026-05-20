#include <string>
#include <vector>

using namespace std;

/*
    그냥 간단하게 skill에 없는 스킬들은 필요 없으니 다 버리면 됨
*/

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    
    for (int i = 0; i < skill_trees.size(); i++) {
        bool isFine = true;
        int idx = 0;
        
        for (int j = 0; j < skill_trees[i].length(); j++) {
            if (skill.find(skill_trees[i][j]) != string::npos) { // 해당하는 글자를 찾았는데
                if (idx >= skill.length()) { // 이미 순서대로 찍혀있다면 
                    break;
                }
                
                if (skill[idx] == skill_trees[i][j]) { // 현재 순서와 일치한다
                    idx++;
                }
                else { // 현재 순서와 일치하지 않는다
                    isFine = false;
                    break;
                }
            }
        }
        
        if (isFine) {
            answer++;
        }
    }
    return answer;
}