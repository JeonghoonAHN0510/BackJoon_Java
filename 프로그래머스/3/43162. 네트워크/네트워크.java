import java.util.*;

class Solution {
    static Map<Integer, Set<Integer>> map = new HashMap<>();
    static boolean[] visited;
    static int count = 0;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i != j && computers[i][j] == 1){
                    map.computeIfAbsent(i, x -> new HashSet<>()).add(j);
                    map.computeIfAbsent(j, x -> new HashSet<>()).add(i);
                } // if end
            } // for end
        } // for end
        
        for (int i = 0; i < n; i++){
            bfs(i);
        } // for end
        
        return count;
    } // func end
    public void bfs(int x){
        if (visited[x]) return;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;
        while (!queue.isEmpty()){
            int y = queue.poll();
            if (map.containsKey(y)){
                Set<Integer> set = map.get(y);
                for (int contact : set){
                    if (visited[contact]) continue;
                    visited[contact] = true;
                    queue.add(contact);
                } // for end
            } // if end
        } // while end
        count++;
    } // func end
} // class end