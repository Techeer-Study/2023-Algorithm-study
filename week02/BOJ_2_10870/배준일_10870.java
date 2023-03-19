package BOJ_2_10870;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 배준일_10870 {
    private static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        sb.append(fibo(n));
        System.out.println(sb);

        sb.setLength(0);
        br.close();
    }

    public static int fibo(Integer n) {
        if(n <= 1)
            return n;
        else {
            return fibo(n - 1) + fibo(n - 2);
        }

    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
