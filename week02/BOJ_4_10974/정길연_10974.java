package BOJ_4_10974;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 정길연_10974 {
    static  int N;
    static int[] number;    // N! 저장
    static int[]  arr;  // 1~
    static boolean[] visited;// N

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        number = new int[N];
        arr = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = i;
        }

        perm(0);
    }

    private static void perm(int cnt) {
        StringBuilder sb;
        if (cnt == N) {
            sb = new StringBuilder();
            for (int n : number) {
                sb.append(n + " ");
            }
            System.out.println(sb);
            return;
        }
        for (int i = 1; i < N + 1; i++) {
            if (visited[i] == true) {
                continue;
            }
            number[cnt] = i;
            visited[i] = true;
            perm(cnt+1);
            visited[i] = false;
        }

    }

}
