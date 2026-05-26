#include <string>
#include <vector>

using namespace std;

/*
    ingredient의 길이는 100만이므로 2중 반복은 불가능
    1 2 3 1 -> 순서가 된다면 바로 사용 가능 
    내가 가장 먼저 생각나는 것은 queue, stack이다.
    
    아니면, ingredient 배열을 순회하면서, 슬라이딩 윈도우처럼 어차피 4개는 고정이니까.
    그럼 만약에 찾았어. 그럼 그 부분들은 어떻게 지울건데? 일일이 erase를 이용해 인덱스를 지울 순 없잖아.
    pair를 만들어서, 값과 이미 사용한 값(1,0)을 이용해서 구분지어놓는 것은 어떠한가?
    
    벡터 버퍼같은 형식을 사용해서 걸러내자?
*/

int solution(vector<int> ingredient) {
    int answer = 0;

    vector<int> buf;
    for (int i = 0; i < ingredient.size(); i++) {
        buf.push_back(ingredient[i]);
        if (buf.size() >= 4) {
            
            if (buf[buf.size()-4] == 1 && buf[buf.size()-3] == 2 && buf[buf.size()-2] == 3 && buf[buf.size()-1] == 1) {
                answer++;
                for (int j = 0; j < 4; j++) {
                    buf.pop_back();
                }
            }
        }
        
    }
    return answer;
}