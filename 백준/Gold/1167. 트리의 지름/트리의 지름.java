import java.io.*;
import java.util.*;

class Node{
    int next;
    int cost;
    public Node(int next, int cost){
        this.next = next;
        this.cost = cost;
    }
}

public class Main {
    static StringBuilder answer = new StringBuilder();
    static List<List<Node>> tree = new ArrayList<>();
    static boolean[] isVisited;
    static int[] costs;
    static int V, maxDistance, finalNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        costs = new int[V + 1];
        for (int i = 0; i <= V; i++){
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++){
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            
            while (true){
                int nextNode = Integer.parseInt(st.nextToken());
                if (nextNode == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                tree.get(node).add(new Node(nextNode, cost));
            }
        }

        isVisited = new boolean[V + 1];
        maxDistance = 0;
        dfs(1, 0);

        isVisited = new boolean[V + 1];
        maxDistance = 0;
        dfs(finalNode, 0);

        answer.append(maxDistance);

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    }
    public static void dfs(int current, int cost){
        isVisited[current] = true;
        if (cost > maxDistance){
            maxDistance = cost;
            finalNode = current;
        }
        for (Node node : tree.get(current)){
            if (!isVisited[node.next]){
                dfs(node.next, cost + node.cost);
            }
        }
    }
}