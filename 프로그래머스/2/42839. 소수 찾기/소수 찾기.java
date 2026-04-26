import java.util.*;

class Solution {
    
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        
        int n = numbers.length();
        visited = new boolean[n];
        
        dfs("", numbers);
        
        int cnt = 0;
        for(int num : set){
            if(isPrime(num)) cnt++;
        }
        
        return cnt;
    }
    
    // 순열 생성
    private static void dfs(String current, String numbers){
        
        if(!current.equals("")){
            set.add(Integer.parseInt(current));
        }
        
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(current + numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
    }
    
    // 소수 판별
    private static boolean isPrime(int num){
        if(num < 2) return false;
        
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
}