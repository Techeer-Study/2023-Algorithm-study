package BOJ_3_1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박희경_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        primeNumber(M, N);
    }

    //에라토스테네스의 체
    static void primeNumber(int m, int n) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[n + 1];

        //배열 초기화화
        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0)
                continue;

            for (int j = i+i; j <= n; j += i) {
                arr[j] = 0;
            }
        }

        for (int i = m; i <= n; i++) {
            if (arr[i] != 0) sb.append(i).append("\n");
        }
        System.out.print(sb);
    }
}
