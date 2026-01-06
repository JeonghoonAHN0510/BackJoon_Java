import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
	int start;
	int end;
	int weight;

	public Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
}

public class Main {
	static StringBuilder answer = new StringBuilder();
	static List<Edge> edges = new ArrayList<>();
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());    // 정점의 개수
		int E = Integer.parseInt(st.nextToken());    // 간선의 개수
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			edges.add(new Edge(A, B, C));
		}

		Collections.sort(edges);

		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}

		int minWeight = 0;
		int edgeCount = 0;

		for (Edge edge : edges) {
			if (find(edge.start) != find(edge.end)) {
				union(edge.start, edge.end);
				minWeight += edge.weight;
				edgeCount++;

				if (edgeCount == V - 1) break;
			}
		}

		answer.append(minWeight);

		bw.write(answer.toString().trim());
		bw.flush();
		bw.close();
	}

	public static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if (rootX != rootY) {
			parent[rootY] = rootX;
		}
	}
}