package BOJ_3_18353;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 박희경_18353 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N + 1];

        Arrays.fill(dp,1);  // 1로 초기화

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
		for (int i = 1; i < N; i++) {  // LIS 알고리즘
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

		System.out.println(N - max);
    }
}
