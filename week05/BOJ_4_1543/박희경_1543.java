package BOJ_4_1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 박희경_1543 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb.append(br.readLine());
        String pattern = br.readLine();

        search(pattern);
    }
    static void search(String pattern) {
        int count = 0;
        int startIdx = 0;

        while((startIdx = sb.toString().indexOf(pattern)) != -1) {
            sb.delete(0, startIdx + pattern.length());
            count++;
        }

        System.out.println(count);
    }
}
