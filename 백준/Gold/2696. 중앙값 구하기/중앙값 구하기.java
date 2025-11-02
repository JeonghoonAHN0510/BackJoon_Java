import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());        // 테스트케이스 T
        for (int i = 0; i < T; i++){
            int M = Integer.parseInt(br.readLine());    // 수열 크기 M
            answer.append(M / 2 + 1).append("\n");
            PriorityQueue<Integer> MaxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> MinHeap = new PriorityQueue<>();
            int count = 0;
            for (int j = 0; j < M; j++){
                if (j % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }
                int x = Integer.parseInt(st.nextToken());
                if (MaxHeap.size() == MinHeap.size()){
                    MaxHeap.offer(x);
                } else {
                    MinHeap.offer(x);
                } // if end
                if (!MinHeap.isEmpty()){
                    if (MaxHeap.peek() > MinHeap.peek()){
                        int temp1 = MaxHeap.poll();
                        int temp2 = MinHeap.poll();
                        MaxHeap.offer(temp2);
                        MinHeap.offer(temp1);
                    } // if end
                } // if end
                if (j % 2 == 0){
                    if (count == 9 || j == M - 1){
                        answer.append(MaxHeap.peek()).append("\n");
                    } else {
                        answer.append(MaxHeap.peek()).append(" ");
                    } // if end
                    count++;
                } // if end
            } // for end
        } // for end

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    } // main end
} // class end