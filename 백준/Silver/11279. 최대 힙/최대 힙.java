import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());        // 연산 개수
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++){
            int input = Integer.parseInt(br.readLine());
            if (input == 0){
                Integer output = maxHeap.poll();
                if (output == null){
                    answer.append(0).append("\n");
                } else {
                    answer.append(output).append("\n");
                } // if end
            } else {
                maxHeap.offer(input);
            } // if end
        } // for end

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    } // main end
} // class end