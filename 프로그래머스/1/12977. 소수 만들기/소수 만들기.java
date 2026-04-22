class Solution {
    
    static int[] arr = new int[3];
    static int answer = 0;
    
    public int solution(int[] nums) {
        
        dfs(0,0,nums);
        
        return answer;
    }
    
    private static void dfs(int depth,int start, int[] n){
        
        if(depth == 3){
            if(isPrime(arr)){
                answer++;
            }
            return;
        }
        
        for(int i=start; i<n.length; i++){
            arr[depth] = n[i];
            dfs(depth+1, i+1, n);
        }
        
        
    }
    
    private static boolean isPrime(int[] a){
        
        int sum = a[0]+a[1]+a[2];
        for(int i=2; i<sum; i++){
            if(sum%i == 0) return false;
        }
        
        return true;
        
    }
}