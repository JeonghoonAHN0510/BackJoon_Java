import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    // 도시 개수 N
        long[] length = new long[N - 1];            // 도시 간 거리 배열
        long[] oilPrice = new long[N];              // 도시 별 가격

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++){
            length[i] = Long.parseLong(st.nextToken());
        } // for end
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            oilPrice[i] = Long.parseLong(st.nextToken());
        } // for end

        long sum = 0;
        long minCost = oilPrice[0];

        for (int i = 0; i < N - 1; i++){
            if (oilPrice[i] < minCost){
                minCost = oilPrice[i];
            } // if end
            sum += minCost * length[i];
        } // for end

        answer.append(sum);

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    } // main end
} // class end