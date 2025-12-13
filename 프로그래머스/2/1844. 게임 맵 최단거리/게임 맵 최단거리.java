import java.util.*;
import java.awt.*;

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visited;
    static int[][] map;
    static int N, M;
    static int answer = -1;
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        map = maps;
        
        visited = new boolean[N][M];
        
        bfs(0, 0);
        
        
        return answer;
    } // func end
    public void bfs(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()){
            Point point = queue.poll();
            if (point.x == N - 1 && point.y == M - 1){
                answer = map[point.x][point.y];
            } // if end
            for (int i = 0; i < 4; i++){
                int nextX = point.x + dx[i];
                int nextY = point.y + dy[i];
                
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if (visited[nextX][nextY]) continue;
                if (map[nextX][nextY] == 0) continue;
                
                visited[nextX][nextY] = true;
                map[nextX][nextY] += map[point.x][point.y];
                queue.add(new Point(nextX, nextY));
            } // for end
        } // while end
    } // func end
} // class end