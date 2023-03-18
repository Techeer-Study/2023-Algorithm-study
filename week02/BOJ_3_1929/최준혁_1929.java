package week02.BOJ_3_1929;

import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class 최준혁_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer input = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(input.nextToken());
        int n = Integer.parseInt(input.nextToken());

        int[] nums = IntStream.range(0, n + 1).toArray();
        nums[1] = 0;    // 1은 소수에서 제외!!

        for (int i = 2; i <= (int)Math.sqrt(n); i++) {  // 제곱근까지 loop를 돌리면 전체 횟수를 줄일 수 있음! 2부터 세주어야 함
            if (nums[i] == 0) continue;
            for (int j = i * i; j < nums.length; j += i) {  // 특정 수의 제곱 이상부터 세주면 됨. 그 이하는 이미 이전 loop에서 제거됨
                nums[j] = 0;
            }
        }

        for (int i = m; i <= n; i++) {
            if (nums[i] != 0) bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }
}
