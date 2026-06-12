import java.util.*;

class Solution {
    /*
        한번에 최대 두명, 무게 제한 존재
        
        무게들을 정렬시키고 큰 것부터.
        제일 큰 것과 제일 작은 것을 더했을 때 limit보다 크면 그냥 큰놈은 1명만 가능하다는거임.
    */
    public int solution(int[] people, int limit) {
        int answer = 0, left = 0, right = people.length - 1;
        
        Arrays.sort(people);
        
        while (left <= right) {
            if (people[left] + people[right] > limit) {
                answer++;
                right--;
            }
            else {
                answer++;
                left++;
                right--;
            }
        }
        
        return answer;
    }
}