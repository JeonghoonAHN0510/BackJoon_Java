import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        Integer[] dp = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            array[i] = number;
        }

        for (int i = 0; i < N; i++) {
            dp(i, array, dp);
        }

        int maxValue = dp[0];
        for (int i = 1; i < N; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }
        
        answer.append(maxValue);

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    }

    public static int dp (int N, int[] array, Integer[] dp) {
        if (dp[N] == null) {
            dp[N] = 1;

            for (int i = N - 1; i >= 0; i--) {
                if (array[i] < array[N]) {
                    dp[N] = Math.max(dp[N], dp(i, array, dp) + 1);
                }
            }
        }
        return dp[N];
    }
}