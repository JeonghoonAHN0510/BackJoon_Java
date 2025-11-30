import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();
    static int[] houses;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        houses = new int[N];
        for (int i = 0; i < N; i++){
            houses[i] = Integer.parseInt(br.readLine());
        } // for end

        Arrays.sort(houses);

        int left = 1;
        int right = houses[N - 1] - houses[0] + 1;
        while (left < right){
            int mid = (left + right) / 2;

            if (canInstall(mid) < M){
                right = mid;
            } else {
                left = mid + 1;
            } // if end
        } // while end

        answer.append(left - 1);

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    } // main end
    public static int canInstall(int distance){
        int count = 1;
        int lastLocate = houses[0];

        for (int i = 1; i < houses.length; i++){
            int locate = houses[i];
            if (locate - lastLocate >= distance){
                count++;
                lastLocate = locate;
            } // if end
        } // for end
        return count;
    } // func end
} // class end