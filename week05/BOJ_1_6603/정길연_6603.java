package BOJ_1_6603;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    로또 - 실버2 (조합)
 */
public class 정길연_6603 {

    static int cnt = 0;
    static int[] arr;
    static int[] numbers;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) System.exit(0);

            numbers = new int[N];
            arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            comb(0, 0);
            numbers = new int[N];
            System.out.println();
        }
    }

    private static void comb(int start, int cnt) {
        if (cnt == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < arr.length; i++) {
            numbers[cnt] = arr[i];
            comb(i+1, cnt+1);
        }


    }
}
