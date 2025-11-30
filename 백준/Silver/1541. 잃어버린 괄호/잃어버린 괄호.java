import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        String[] a = line.split("-");
        int total = 0;
        for (int i = 0; i < a.length; i++){
            String str = a[i];
            int sum = 0;
            if (str.contains("+")){
                String[] b = str.split("\\+");
                for (String c : b){
                    sum += Integer.parseInt(c);
                } // for end
            } else {
                sum += Integer.parseInt(str);
            } // if end
            if (i == 0){
                total = sum;
            } else {
                total -= sum;
            } // if end
        } // for end

        answer.append(total);

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    } // main end
} // class end