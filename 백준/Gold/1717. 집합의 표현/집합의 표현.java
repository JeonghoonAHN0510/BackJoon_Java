import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();
    static int[] parent;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());       // 집합의 개수
        m = Integer.parseInt(st.nextToken());       // 연산의 개수

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int isPrint = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (isPrint == 0){
                union(a, b);
            } else {
                if (find(a) == find(b)){
                    answer.append("YES").append("\n");
                } else {
                    answer.append("NO").append("\n");
                }
            }
        }

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    }
    public static int find(int x){
        if (x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB){
            parent[rootB] = rootA;
        }
    }
}