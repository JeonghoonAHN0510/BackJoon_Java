import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder answer = new StringBuilder();
	static List<Integer>[] graph;
	static boolean[] visited;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());    // 테스트 케이스 수
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());    // 국가의 수
			int m = Integer.parseInt(st.nextToken());    // 비행기의 종류

			graph = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				graph[u].add(v);
				graph[v].add(u);
			}
			visited = new boolean[n + 1];
			result = 0;
			bfs(1);
			answer.append(result).append("\n");
		}

		bw.write(answer.toString().trim());
		bw.flush();
		bw.close();
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int next : graph[current]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
					result++;
				}
			}
		}
	}
}