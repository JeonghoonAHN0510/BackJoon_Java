import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());        // 회의 개수 N
        int[][] time = new int[N][2];                   // 0 : 시작시간, 1 : 종료시간

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        } // for end

        Arrays.sort(time, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            } // func end
        });

        int count = 0;
        int prev_time = 0;
        for (int i = 0; i < N; i++){
            if (prev_time <= time[i][0]){
                count++;
                prev_time = time[i][1];
            } // if end
        } // for end

        answer.append(count);

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    } // main end
} // class end