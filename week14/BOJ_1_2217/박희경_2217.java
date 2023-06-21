package BOJ_1_2217;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class 박희경_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] rope = new int[N];

        for (int i = 0; i < N; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope);

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            max = Math.max(max, rope[i] * (N - i));
        }

        System.out.println(max);
    }
}
