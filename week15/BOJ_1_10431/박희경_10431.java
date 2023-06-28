package BOJ_1_10431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박희경_10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int P = Integer.parseInt(br.readLine());

        for (int t = 1; t < P + 1; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            sb.append(st.nextToken()).append(" ");

            int[] arr = new int[20];
            int cnt = 0;

            for (int i = 0; i < arr.length; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < i; j++) {
                    if(arr[j] > arr[i])
                        cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
