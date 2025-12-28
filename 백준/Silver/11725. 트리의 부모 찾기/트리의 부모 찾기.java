import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();
    static List<List<Integer>> tree = new ArrayList<>();
    static boolean[] isVisited;
    static int[] parentNodes;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());    // 노드의 개수
        parentNodes = new int[N + 1];
        isVisited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++){
            tree.add(new ArrayList<>());
        } // for end

        for (int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        } // for end

        dfs(1);

        for (int i = 2; i <= N; i++){
            answer.append(parentNodes[i]).append("\n");
        } // for end

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    } // main end
    public static void dfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;
        while (!queue.isEmpty()){
            int node = queue.poll();
            for (int next : tree.get(node)){
                if (!isVisited[next]){
                    isVisited[next] = true;
                    parentNodes[next] = node;
                    queue.add(next);
                } // if end
            } // for end
        } // while end
    } // func end
} // class end