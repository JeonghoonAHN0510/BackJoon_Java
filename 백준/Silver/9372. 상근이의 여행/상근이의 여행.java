import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());    // 테스트 케이스 수
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());    // 국가의 수
			int m = Integer.parseInt(st.nextToken());    // 비행기의 종류

			for (int i = 0; i < m; i++) {
				br.readLine();
			}
			answer.append(n - 1).append("\n");
		}

		bw.write(answer.toString().trim());
		bw.flush();
		bw.close();
	}
}