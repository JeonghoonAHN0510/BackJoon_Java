import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();
    static char[][] chessBoard;
	static int[][] sumBoard;
    static int N, M, K;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
		chessBoard = new char[N][M];
		sumBoard = new int[N + 1][M + 1];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				chessBoard[i][j] = line.charAt(j);

				boolean isBlack = (i + j) % 2 == 0;
				int value = 0;

				if (isBlack) {
					if (chessBoard[i][j] != 'B') value = 1;
				} else {
					if (chessBoard[i][j] != 'W') value = 1;
				}
				sumBoard[i + 1][j + 1] = sumBoard[i][j + 1] + sumBoard[i + 1][j] - sumBoard[i][j] + value;
			}
		}

		int minCount = Integer.MAX_VALUE;
		for (int i = K; i <= N; i++) {
			for (int j = K; j <= M; j++) {
				int countBlack = sumBoard[i][j] - sumBoard[i - K][j] - sumBoard[i][j - K] + sumBoard[i - K][j - K];

				int countWhite = (K * K) - countBlack;

				minCount = Math.min(minCount, Math.min(countBlack, countWhite));
			}
		}

		answer.append(minCount);

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    }
}