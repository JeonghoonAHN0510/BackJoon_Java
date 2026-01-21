import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 날짜의 수
        int K = Integer.parseInt(st.nextToken());   // 연속적인 날짜의 수
        int[] PrefixSum = new int[N];

        st = new StringTokenizer(br.readLine());
        PrefixSum[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            PrefixSum[i] = input + PrefixSum[i - 1];
        }

        int[] result = new int[N - K + 1];
        int interval = K;
        for (int i = 0; i < N - K + 1; i++) {
            if (i == 0) {
                result[i] = PrefixSum[interval - 1];
            } else {
                result[i] = PrefixSum[interval - 1] - PrefixSum[i - 1];
            }
            interval++;
        }

        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < result.length; i++) {
            maxValue = Math.max(maxValue, result[i]);
        }

        answer.append(maxValue);

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    }
}