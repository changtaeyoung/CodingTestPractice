#include <string>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

/*
    위치가 이렇게 되어있다고 가정한다.
    1 2 3
    4 5 6
    7 8 9
    10 11 12
*/

int dist(int a, int b) {
    int rowA = (a - 1) / 3, colA = (a - 1) % 3;
    int rowB = (b - 1) / 3, colB = (b - 1) % 3;
    return abs(rowA - rowB) + abs(colA - colB);
}

string solution(vector<int> numbers, string hand) {
    string answer = "";
    int leftHand = 10, rightHand = 12; // *과 # 위치에 있으니까

    for (int i = 0; i < numbers.size(); i++) {
        int target = (numbers[i] == 0) ? 11 : numbers[i];

        if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
            leftHand = numbers[i];
            answer += "L";
        }
        else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
            rightHand = numbers[i];
            answer += "R";
        }
        else {
            int leftLen = dist(leftHand, target);
            int rightLen = dist(rightHand, target);

            if (leftLen < rightLen) {
                leftHand = target;
                answer += "L";
            }
            else if (leftLen > rightLen) {
                rightHand = target;
                answer += "R";
            }
            else {
                if (hand == "right") {
                    rightHand = target;
                    answer += "R";
                }
                else {
                    leftHand = target;
                    answer += "L";
                }
            }
        }
    }

    return answer;
}