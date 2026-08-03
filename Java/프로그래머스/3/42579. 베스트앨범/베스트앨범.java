import java.util.*;

class Solution {
    /*
        필요한 것이, 
        genres의 순서대로 고유번호를 지님.
        장르 내 많이 재생된 노래를 먼저 수록
        
        결국 장르별 순서를 나타내기 위한 합계를 알아야지.
    */
    public int[] solution(String[] genres, int[] plays) {
        // genre, [재생 횟수, 고유 번호]
        Map<String, List<int[]>> musics = new HashMap<>();
        // genre, 장르별 합산
        Map<String, Integer> sums = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            if (!musics.containsKey(genres[i])) {
                musics.put(genres[i], new ArrayList<>());
            }
            musics.get(genres[i]).add(new int[]{plays[i], i});
            sums.put(genres[i], sums.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 합산도 완료 했고, 재생횟수 고유번호도 적용이 됐는데.. 그럼 어떻게 해야할까?
        // List같은 경우 Collections.sort, reverseOrder를 적용하면 내림차순으로 적용이 될 텐데
        // 여기서 가장 큰 거 2개만 적용하면 되거든? 근데 가장 많이 재생된 장르를 어떻게 구하냐가 문제인데.
        // 가장 큰 것을 찾은다음에 remove? 그러면 효율성이 안좋아질 거 같은데..
        List<Map.Entry<String, Integer>> genreList = new ArrayList<>(sums.entrySet());
        genreList.sort((a, b) -> b.getValue() - a.getValue());
        
        List<Integer> answer = new ArrayList<>();
        
        for (Map.Entry<String, Integer> entry : genreList) {
            String gen = entry.getKey();
            List<int[]> songs = musics.get(gen);
            songs.sort((a, b) -> b[0] - a[0]);
            
            for (int i = 0; i < Math.min(songs.size(), 2); i++) {
                answer.add(songs.get(i)[1]);
            }
        }
        
        int[] ans = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }
}