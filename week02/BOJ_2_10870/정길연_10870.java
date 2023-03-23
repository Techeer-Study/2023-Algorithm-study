package BOJ_2_10870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 정길연_10870  {

    static int cnt = 1;
    static int N, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if(N <0 || N>20) return;

        switch (N){
            case(0):
                System.out.println(0);
                return;
            case (1):
                System.out.println(1);
                return;
        }

        while (cnt != N) {
            fibo(0,1);
        }

        System.out.println(result);
    }

    private static void fibo(int a, int b) {
        cnt ++;
        if (cnt == N) {
            result = a+b;
            return;
        }

        fibo(b, a + b);
    }
}
