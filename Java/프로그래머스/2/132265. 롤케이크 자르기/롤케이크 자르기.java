import java.util.*;

class Solution {
    /*
        각 조각에 동일한 가짓수의 토핑이 올라가면 공평함
        
        개수만 확인하면 됨. 토핑의 순서는 정해져 있으므로 정렬은 하면 안돼.
        100만의 길이를 가지기 때문에 브루트 포스 사용 불가
        
        1번째 생각: 
        for문을 이용해서, 각각 형과 동생의 set을 이용해서 size가 같으면 그거를 활용하면 되지 않을까?
        아 그러면 개수 셀 때 2중 반복이 들어가기 때문에 안되겠다.
        
        2번째: 이분 탐색으로 중간부터 잘라보고, 한쪽에 치중되어 있을 경우, 그 치중되어있는 쪽으로 더 간다?
        -> 이게 얼추 맞을 거 같은 느낌이 드는데
        -> 구현하다 보니 아닌 것을 깨달음.
        
        3번째: 아니면 Map을 이용해서 개수를 모두 센 뒤에, for문을 이용해서 하나씩 0에서부터 옮겨 가면서
        동생에서는 1개를 빼주고, 형에게는 1개씩 추가해주면 되지 않나?
        
    */
    public int solution(int[] topping) {
        
        Map<Integer, Integer> oldB = new HashMap<>();
        Map<Integer, Integer> youngB = new HashMap<>();
        int answer = 0;
        
        for (int i = 0; i < topping.length; i++) {
            youngB.put(topping[i], youngB.getOrDefault(topping[i], 0) + 1);
        }
        
        for (int i = 0; i < topping.length; i++) {
            oldB.put(topping[i], oldB.getOrDefault(topping[i], 0) + 1);
            youngB.put(topping[i], youngB.get(topping[i]) - 1);
            if (youngB.get(topping[i]) == 0) {
                youngB.remove(topping[i]);
            }
            
            if (oldB.size() == youngB.size()) {
                answer++;
            }            
        }
        return answer;
    }
}