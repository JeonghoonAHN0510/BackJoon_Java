import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();
    static final int INF = 9900001;
    static int[][] result;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        result = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    result[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            result[a][b] = Math.min(result[a][b], c);
        }

        floydWarshall(N);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (result[i][j] == INF) {
                    answer.append("0");
                } else {
                    answer.append(result[i][j]);
                }
                answer.append(" ");
            }
            answer.append("\n");
        }

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    }

    public static void floydWarshall (int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    for (int k = 1; k <= n; k++) {
                        if (i != k && j != k) {
                            if (result[j][k] > result[j][i] + result[i][k]) {
                                result[j][k] = result[j][i] + result[i][k];
                            }
                        }
                    }
                }
            }
        }
    }
}