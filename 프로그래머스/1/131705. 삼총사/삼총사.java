class Solution {

    static int answer = 0;
    static int[] arr = new int[3];
    
    public int solution(int[] number) {
        
        
        dfs(0,0,number);
        
        
        return answer;
    }
    
    private static void dfs(int depth, int start, int[]number){
        
        if(depth == 3){
            if(arr[0] + arr[1] + arr[2] == 0){
                answer++;
            }
            return;
        }
        
        for(int i=start; i<number.length; i++){
            arr[depth] = number[i];
            dfs(depth +1, i+1, number);
        }
    }
}