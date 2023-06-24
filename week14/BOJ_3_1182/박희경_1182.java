package BOJ_3_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박희경_1182 {
    private static int N, S;
    static int[] num;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (S == 0)
            System.out.println(answer - 1);
        else
            System.out.println(answer);

    }

    private static void dfs(int index, int sum) {
        if(index == N) {
            if(sum == S) {
                answer++;
            }
            return;
        }
        dfs(index+1, sum + num[index]);
        dfs(index+1, sum);
    }
}
