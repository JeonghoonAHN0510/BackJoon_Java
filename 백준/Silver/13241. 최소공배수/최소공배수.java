import java.io.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long max = Math.max( A, B );
        long min = Math.min( A, B );
        while( min > 0 ){
            long num = max % min;
            max = min;
            min = num;
        } // while end

        for ( long i = Math.max( A, B ); ; i = i + Math.max( A, B ) ){
            if ( i % A == 0 && i % B == 0 && i % max == 0 ){
                answer.append( i );
                break;
            } // if end
        } // for end

        bw.write( answer.toString().trim() );
        bw.flush();
        bw.close();
    } // main end
} // class end