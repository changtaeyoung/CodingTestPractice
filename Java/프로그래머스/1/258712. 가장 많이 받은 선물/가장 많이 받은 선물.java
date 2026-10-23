import java.util.*;
/*
    더 많은 선물을 준 사람이 다음 달에 선물을 하나 받는다.
    
    하나도 없거나 주고 받은 수가 같으면 선물 지수가 더 큰 사람이 작은 사람에게 선물을 하나 받는다.
    선물 지수 = 준 선물 - 받은 선물
    
    선물 지수까지 같으면 주고받지 않음.
    
    걍 이차원 행렬 갈기는 게 나을듯
*/
class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        int[][] giftmap = new int[friends.length][friends.length];
        
        // 선물 맵 다 채우기
        for (int i = 0; i < gifts.length; i++) {
            String[] str = gifts[i].split(" ");
            
            int give = -1, get = -1;
            for (int j = 0; j < friends.length; j++) {
                if (str[0].equals(friends[j])) {
                    give = j;
                }
                
                if (str[1].equals(friends[j])) {
                    get = j;
                }
                
                if (give != -1 && get != -1) { // 준 사람, 받은 사람 둘 다 찾았으니까 break
                    break;
                }
            }
            giftmap[give][get] += 1;
        }
        
        // int[] giftnum = new int[friends.length]; // 선물 지수 체크 용도.. 미리 계산해놨으면 좋을듯
        int[] havetoGet = new int[friends.length];
        for (int i = 0; i < giftmap.length; i++) {
            for (int j = i + 1; j < giftmap[i].length; j++) {
                if (i != j) { // 자신에게 선물하기 없으니까
                    // 준 개수와 받은 개수
                    if (giftmap[i][j] > giftmap[j][i]) {
                        havetoGet[i]++;
                    }
                    else if (giftmap[i][j] < giftmap[j][i]) {
                        havetoGet[j]++;
                    }
                    else { // 선물 지수 체크해봐야 됨..
                        int sumGive1 = 0, sumGive2 = 0;
                        for (int k = 0; k < giftmap[i].length; k++) {
                            if (i != k) {
                                sumGive1 += giftmap[i][k];
                            }
                        }
                        
                        for (int k = 0; k < giftmap.length; k++) {
                            if (i != k) {
                                sumGive1 -= giftmap[k][i];
                            }
                        }
                        //giftnum[i] = sumGive;
                        
                        for (int k = 0; k < giftmap[j].length; k++) {
                            if (j != k) {
                                sumGive2 += giftmap[j][k];
                            }
                        }
                        
                        for (int k = 0; k < giftmap.length; k++) {
                            if (j != k) {
                                sumGive2 -= giftmap[k][j];
                            }
                        } 
                        //giftnum[j] = sumGive;
                        
                        if (sumGive1 < sumGive2) {
                            havetoGet[j]++;
                        }
                        else if (sumGive1 > sumGive2) {
                            havetoGet[i]++;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < havetoGet.length; i++) {
            if (ans < havetoGet[i]) {
                ans = havetoGet[i];
            }
        }
        return ans;
    }
}