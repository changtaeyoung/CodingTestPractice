import java.util.*;
/*
    할인하는 날짜와 10일 연속으로 일치할 경우 -> 회원가입
    슬라이딩 윈도우를 적용하면 되지 않을까 싶은데.
    예를 들어 0~9 -> 1~10 -> 2~11 등.. 이런 식으로 적용하면 되지 않을까
    그 안에서 제품들의 개수를 세는거지
    할인된 제품의 수는 하루에 1개밖에 못산다고 못 박아뒀잖아.
*/
class Solution {
    private boolean check (String[] wants, int[] nums, Map<String, Integer> w) {
        for (int i = 0; i < wants.length; i++) {
            if (w.getOrDefault(wants[i], 0) < nums[i]) return false;
        }
        return true;
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> ifRegiToday = new HashMap<>();
        int can = 0, left = 0, right = 9;
        
        // 초기값 설정 - 0일에 회원가입을 했을 경우
        for (int i = left; i <= right; i++) {
            ifRegiToday.put(discount[i], ifRegiToday.getOrDefault(discount[i], 0) + 1);
        }
        
        // 판단 해야지
        if (check(want, number, ifRegiToday)) can++;
        if (discount.length > right) {
            right++;
        }
        else if (discount.length == right) {
            return can;
        }
        
        while (right < discount.length) {
            // 지우지 않고 0으로 저장해놓기
            if (ifRegiToday.getOrDefault(discount[left], 0) < 1) {
                ifRegiToday.put(discount[left], 0);
            }
            else { // 1 이상 있다면 좌측은 한칸 이동할 거니까 그 위치에 있는 값 빼고 이동
                ifRegiToday.put(discount[left], ifRegiToday.get(discount[left]) - 1);
            }
            left++;
            
            // 우측 값은 위에서 이동했으니 개수 갱신
            ifRegiToday.put(discount[right], ifRegiToday.getOrDefault(discount[right], 0) + 1);
            // 판단
            if (check(want, number, ifRegiToday)) can++;
            
            // 슬라이딩 윈도우 이동
            right++;
        }
        
        return can;
    }
}