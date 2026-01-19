import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] grapes = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            grapes[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = grapes[1];
        if (N > 1) {
            dp[2] = grapes[1] + grapes[2];
        }

        for (int i = 3; i <= N; i++) {
            int case1 = dp[i - 2] + grapes[i];
            int case2 = dp[i - 3] + grapes[i] + grapes[i - 1];

            dp[i] = Math.max(dp[i - 1], Math.max(case1, case2));
        }

        answer.append(dp[N]);

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    }
}