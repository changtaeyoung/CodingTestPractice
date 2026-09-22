import java.util.*;

class Solution {
    /*
        어떤 자료구조를 쓰는 가에 따라서 효율적인 풀이가 될 거 같음.
        일단 처음 든 생각은 큐를 이용하여, 빼고 넣고 하는 것인데, 매번 하게 된다면 10만번을 적용해야하니 비효율.
        어떻게 해야할까.....
        
        맵을 이용해서, 키로 도시, 밸류로 위치를 계산하는거지. 근데 만약 변동될 경우는 어떡할건데..
    */
    public int solution(int cacheSize, String[] cities) {
        List<String> cache = new ArrayList<>();
        int time = 0;
        
        for (int i = 0; i < cities.length; i++) {
            if (cacheSize == 0) {
                time += 5;
                continue;
            }
            
            if (cache.contains(cities[i].toLowerCase())) {
                time += 1; // cache hit
                cache.remove(cache.indexOf(cities[i].toLowerCase()));
                cache.add(cities[i].toLowerCase());
            }
            else { // cache miss
                time += 5;
                if (cache.size() == cacheSize) { // cache가 꽉 찼을 때
                    cache.remove(0);
                }
                cache.add(cities[i].toLowerCase());
            }
        }
        
        return time;
    }
}