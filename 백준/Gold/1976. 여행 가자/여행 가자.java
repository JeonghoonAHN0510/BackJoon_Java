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

        n = Integer.parseInt(br.readLine());       // 도시의 개수
        m = Integer.parseInt(br.readLine());       // 여행계획의 도시 개수

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int isConnect = Integer.parseInt(st.nextToken());
                if (isConnect == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        boolean isPossible = true;
        for (int i = 1; i < m; i++) {
            int nextCity = Integer.parseInt(st.nextToken());
            if (find(start) != find(nextCity)){
                isPossible = false;
                break;
            }
            start = nextCity;
        }

        if (isPossible) {
            answer.append("YES");
        } else {
            answer.append("NO");
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