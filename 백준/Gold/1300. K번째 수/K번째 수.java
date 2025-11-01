import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());        // 크기가 N*N인 배열
        int K = Integer.parseInt(br.readLine());        // K번째 수 구하기

        long left = 1;
        long right = K;

        while (left < right){
            long mid = (left + right) / 2;
            long count = 0;
            for (int i = 1; i <= N; i++){
                count += Math.min(mid / i, N);
            } // for end

            if (K <= count){
                right = mid;
            } else {
                left = mid + 1;
            } // if end
        } // while end

        answer.append(left);

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    } // main end
} // class end