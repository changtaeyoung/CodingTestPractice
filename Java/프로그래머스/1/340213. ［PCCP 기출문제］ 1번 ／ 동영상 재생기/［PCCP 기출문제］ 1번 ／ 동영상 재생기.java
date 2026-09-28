import java.util.*;

class Solution {
    /*
        prev : 10초 전으로. 10초 미만일 경우 0분0초
        next : 10초 후로, 남은 시간 10초 미만일 경우 마지막 위치. (동영상 길이와 같음)
        
    */
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        // 비디오 길이(영상 길이) int type
        String[] strV = video_len.split(":");
        int vTime = Integer.parseInt(strV[0]) * 60 + Integer.parseInt(strV[1]);

        // 현재 위치 시간을 int 타입으로 변환
        String[] strP = pos.split(":");
        int pTime = Integer.parseInt(strP[0]) * 60 + Integer.parseInt(strP[1]);

        String[] strOs = op_start.split(":");
        int osTime = Integer.parseInt(strOs[0]) * 60 + Integer.parseInt(strOs[1]);

        String[] strOe = op_end.split(":");
        int oeTime = Integer.parseInt(strOe[0]) * 60 + Integer.parseInt(strOe[1]);
        
        for (int i = 0; i < commands.length; i++) {
            String order = commands[i];
                        
            // 적용 후 오프닝 사이에 존재한다면 자동 건너뛰기
            if (pTime >= osTime && pTime <= oeTime) {
                pTime = oeTime;
            }
            
            // 커맨드 적용
            if (order.equals("next")) {
                pTime += 10;
                if (pTime > vTime) pTime = vTime;
            }
            else if (order.equals("prev")) {
                pTime -= 10;
                if (pTime < 0) pTime = 0;
            }
        }
        // 커맨드 모두 적용 후 오프닝 사이에 존재한다면 자동 건너뛰기
        if (pTime >= osTime && pTime <= oeTime) {
            pTime = oeTime;
        }
        
        String[] ans = new String[2];
        if (pTime / 60 < 10) {
            ans[0] = "0" + String.valueOf(pTime / 60);
        }
        else {
            ans[0] = String.valueOf(pTime / 60);
        }
        
        if (pTime % 60 < 10) {
            ans[1] = "0" + String.valueOf(pTime % 60);
        }
        else {
            ans[1] = String.valueOf(pTime % 60);
        }
        
        String answer = ans[0] + ":" + ans[1];
        return answer;
    }
}