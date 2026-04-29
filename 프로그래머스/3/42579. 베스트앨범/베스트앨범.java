// 정렬 기준 : 장르 -> 노래 -> 고유번호
// 고유번호 = 인덱스
// 각 장르별 노래를 두개씩
import java.util.*;
class Solution {
    
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        int N = genres.length;
        
        // 1. 장르를 기준으로 재생횟수가 더 높은걸 선택
        // 각 장르별 재생횟수 통합하기
        for(int i=0; i<N; i++){
            map.put(genres[i], map.getOrDefault(genres[i],0) + plays[i]);
        }
        
        // 재생횟수로 정렬 저장된 자료구조 필요
        List<String> sg  = new ArrayList<>(map.keySet());
        
        sg.sort((a,b)-> map.get(b).compareTo(map.get(a)));
        
        
        // 2. 노래를 기준으로 재생횟수가 더 높은걸 선택
        
        // 장르별로 [재생횟수, 고유번호]로 묶기 
        HashMap<String, List<int[]>> songMap = new HashMap<>();
        
        for(int i=0; i<N; i++){
            songMap.putIfAbsent(genres[i], new ArrayList<>());
            songMap.get(genres[i]).add(new int[]{plays[i], i});
        }
        
        for(String genre : songMap.keySet()){
            List<int[]> list = songMap.get(genre);
            
            list.sort((a,b)->{
                if(a[0]!=b[0]) return b[0]-a[0];
                return a[1] - b[1];
            });
        }
        
        List<Integer> result = new ArrayList<>();
        
        for(String g : sg){
            List<int[]> list = songMap.get(g);
            
            for(int i=0; i<Math.min(2, list.size()); i++){
                result.add(list.get(i)[1]);
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        
        return answer;
    }
}