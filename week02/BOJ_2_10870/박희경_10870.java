package BOJ_2_10870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 박희경_10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(fibonacci(n));

    }

    // 피보나치 함수 (재귀)
    public static int fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
