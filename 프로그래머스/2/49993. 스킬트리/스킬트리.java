class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        int answer = 0;
        
        for (String s : skill_trees){
            
            String filtered = "";
            
            // skill에 포함되는 스킬만 필터링
            for(char c : s.toCharArray()){
                if(skill.contains(String.valueOf(c))){
                    filtered += c;
                }
            }
            
            // skill의 prefix를 갖고있는지 판단
            if(skill.startsWith(filtered)){
                answer++;
            }
            
        }
        return answer;
    }
}