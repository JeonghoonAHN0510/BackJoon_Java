import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();
    static int[] coins;
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coins = new int[N];
        int count = 0;
        for (int i = 0; i < N; i++){
            int coin = Integer.parseInt(br.readLine());
            if (coin <= K){
                coins[i] = coin;
                count++;
            } // if end
        } // for end
        int coinCount = 0;
        for (int i = count-1; i >= 0; i--){
            coinCount += K / coins[i];
            K = K % coins[i];
        } // for end
        answer.append(coinCount);
        
        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    } // main end
} // class end