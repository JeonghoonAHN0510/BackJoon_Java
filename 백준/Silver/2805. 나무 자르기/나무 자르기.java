import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 나무 개수 N
        int M = Integer.parseInt(st.nextToken());       // 가져가려는 나무 길이 M
        long[] lengths = new long[N];                     // 나무 길이 배열
        st = new StringTokenizer(br.readLine());
        long maxLength = 0;
        for (int i = 0; i < N; i++){
            lengths[i] = Integer.parseInt(st.nextToken());
            maxLength = Math.max(maxLength, lengths[i]);
        } // for end

        long left = 0;
        long right = maxLength;
        long maxResult = 0;
        while (left <= right){
            long mid = (left + right) / 2;
            long cutLength = 0;
            for (int i = 0; i < N; i++){
                if (lengths[i] >= mid){
                    cutLength += lengths[i] - mid;
                } // if end
            } // for end
            if (cutLength >= M){
                left = mid + 1;
                maxResult = mid;
            } else {
                right = mid - 1;
            } // if end
        } // while end

        answer.append(maxResult);

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    } // main end
} // class end