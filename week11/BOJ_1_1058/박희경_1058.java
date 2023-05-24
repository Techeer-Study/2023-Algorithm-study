package BOJ_1_1058;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 박희경_1058 {
    public static int MAX_VALUE = Integer.MAX_VALUE >> 2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] friends = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == 'N')
                    friends[i][j] = MAX_VALUE;
                else
                    friends[i][j] = 1;
                if (i == j)
                    friends[i][j] = 0;
            }
        }
        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    friends[i][j] = Math.min(friends[i][j], friends[i][k] + friends[k][j]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;
                if (friends[i][j] <= 2)
                    count++;
            }
            ans = Math.max(ans, count);
        }
        System.out.println(ans);
    }
}
