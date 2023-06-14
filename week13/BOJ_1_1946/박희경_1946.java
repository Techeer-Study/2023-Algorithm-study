package BOJ_1_1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박희경_1946 {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); // 서류 순위
                int b = Integer.parseInt(st.nextToken()); // 면접 순위
                arr[a] = b;
            }

            int count = 1;
            int vot = arr[1];

            for (int j = 2; j <= N; j++) {
                if (arr[j] < vot) {
                    count++;
                    vot = arr[j];
                }
            }
            sb.append(count);
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
