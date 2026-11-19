import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> m = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            m.put(players[i], i);
        }
        
        for (int i = 0; i < callings.length; i++) {
            String name = callings[i];
            int cRank = m.get(name);
            String chName = players[cRank - 1];
            
            players[cRank - 1] = name;
            players[cRank] = chName;
            
            m.put(name, cRank - 1);
            m.put(chName, cRank);
        }
        
        return players;
    }
}