import java.util.*;
class Solution {
    
    static int[][] visited;
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};
    
    public int solution(int[][] maps) {

        int N = maps.length;
        int M = maps[0].length;

        bfs(0,0, maps);
        
        int answer = visited[N-1][M-1];
        if(answer == 0) return -1;
        else return answer;
    }
    
    private static void bfs(int y, int x, int[][]maps){
        
        int N = maps.length;
        int M = maps[0].length;
        
        visited = new int[N][M];
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x});
        
        visited[y][x] = 1;
        
        while(!q.isEmpty()){
            
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];
            
            for(int d=0; d<4; d++){
                int ny = cy + dy[d];
                int nx = cx + dx[d];
                
                if(ny <0 || nx <0 || ny>= N || nx >= M) continue;
                
                // 방문 안했고 벽이 아니면 BFS 수행
                if(visited[ny][nx]==0 && maps[ny][nx] == 1){
                    // 거리 계산
                    visited[ny][nx] = visited[cy][cx] + 1;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
        
    }
}