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
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = array[0];
        int maxValue = array[0];

        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            maxValue = Math.max(maxValue, dp[i]);
        }

        answer.append(maxValue);

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    }
}