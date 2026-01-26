import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        String S = br.readLine();                   // 검사할 문자열 S
        int[][] array = new int[S.length()][26];    // 누적합을 구할 2차원 배열
        array[0][S.charAt(0)-'a'] = 1;
        for ( int i = 1; i < S.length(); i++ ){
            // 이전 줄의 누적합을 그대로 복사
            for ( int j = 0; j < 26; j++ ){
                array[i][j] = array[i-1][j];
            } // for end
            // 현재 문자에 해당하는 값만 1 증가
            array[i][S.charAt(i) - 'a']++;
        } // for end
        int q = Integer.parseInt(br.readLine());    // 질문의 수 q
        for ( int i = 0; i < q; i++ ){
            st = new StringTokenizer(br.readLine());
            int check = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());   // l부터
            int r = Integer.parseInt(st.nextToken());   // r까지 검사인데
            if ( l == 0 ){
                answer.append(array[r][check]).append("\n");
            } else {
                answer.append(array[r][check] - array[l-1][check]).append("\n");
            } // if end
        } // for end

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    } // main end
} // class end