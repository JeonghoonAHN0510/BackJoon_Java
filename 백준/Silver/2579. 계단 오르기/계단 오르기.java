import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());        // 계단 개수 N
        int[] stairs = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        } // for end

        dp[1] = stairs[1];
        if (N >= 2) dp[2] = stairs[1] + stairs[2];
        for (int i = 3; i <= N; i++){
            // 1. i - 2에서 두 계단 오른 경우
            int case1 = dp[i - 2] + stairs[i];
            // 2. i - 3에서 i - 1, i로 오른 경우
            int case2 = dp[i - 3] + stairs[i - 1] + stairs[i];
            dp[i] = Math.max(case1, case2);
        } // for end

        answer.append(dp[N]);

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    } // main end
} // class end