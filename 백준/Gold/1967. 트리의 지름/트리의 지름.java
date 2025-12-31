import java.io.*;
import java.util.*;

class Edge {
    int node;
    int cost;
    public Edge(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
}

public class Main {
    static StringBuilder answer = new StringBuilder();
    static List<List<Edge>> tree = new ArrayList<>();
    static boolean[] isVisited;
    static int nodeNumbers, maxDistance, finalNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        nodeNumbers = Integer.parseInt(br.readLine());  // 노드의 개수
        for (int i = 0; i <= nodeNumbers; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < nodeNumbers; i++) {
            st = new StringTokenizer(br.readLine());
            int parentNode = Integer.parseInt(st.nextToken());
            int childNode = Integer.parseInt(st.nextToken());
            int edgeWeight = Integer.parseInt(st.nextToken());
            tree.get(parentNode).add(new Edge(childNode, edgeWeight));
            tree.get(childNode).add(new Edge(parentNode, edgeWeight));
        }

        isVisited = new boolean[nodeNumbers + 1];
        maxDistance = 0;
        dfs(1, 0);

        isVisited = new boolean[nodeNumbers + 1];
        maxDistance = 0;
        dfs(finalNode, 0);

        answer.append(maxDistance);

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    }
    public static void dfs(int currentNode, int cost){
        isVisited[currentNode] = true;
        if (cost > maxDistance) {
            maxDistance = cost;
            finalNode = currentNode;
        }
        for (Edge currentEdge : tree.get(currentNode)) {
            if (!isVisited[currentEdge.node]) {
                dfs(currentEdge.node, cost + currentEdge.cost);
            }
        }
    }
}