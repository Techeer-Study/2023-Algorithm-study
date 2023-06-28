package BOJ_5_2531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박희경_2531 {
    static int N, d, k, c;
    static int[] sushi;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        sushi = new int[N];

        int max=0;

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int [] check = new int[d + 1];
        int count = 0;

        for (int i = 0; i < k; i++) {
            if(check[sushi[i]] == 0)
                count++;
            check[sushi[i]]++;
        }

        max = count;
        int start = 1, end = k;
        while (true) {
            if (check[sushi[start - 1]] == 1) count--;
            check[sushi[start - 1]]--;

            if (check[sushi[end]] == 0) count++;
            check[sushi[end]]++;

            if (check[c] == 0) max = Math.max(max, count + 1);
            else max = Math.max(max, count);

            start++;
            end++;

            if (end == N) end=0;
            if (start == N) break;
        }
        System.out.println(max);
    }
}
