package BOJ_2_1359;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박희경_1359 {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        double res = 0.0;

        double p = combination(N, M);
        while(M >= K) {
            if (N - M < M - K) {
                K++;
                continue;
            }
            double c = combination(M, K) * combination(N - M, M - K);

            res += c / p;
            K++;
        }
        System.out.println(res);
    }

    private static long combination(int a, int b) {
        int n = 1;
        int r = 1;
        while (b > 0) {
            n *= a--;
            r *= b--;
        }
        return n / r;
    }
}
