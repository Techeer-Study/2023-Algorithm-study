package BOJ_1_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 박희경_1012 {
    static int M, N, K;
    static int[][] map; // 배추밭
    static boolean[][] visit;
    static int count;
    static int[] dx = { 0, -1, 0, 1 }; // 상하좌우
    static int[] dy = { 1, 0, -1, 0 };  // 상하좌우
    static Queue<int[]> qu = new LinkedList<int[]>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int c = 0; c < T; c++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[M][N];
            visit = new boolean[M][N];
            count=0;

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine()," ");
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                map[p1][p2] = 1;

            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1 && !visit[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    static void bfs(int x, int y) {
        qu.add(new int[] { x, y });

        while (!qu.isEmpty()) {
            x = qu.peek()[0];
            y = qu.peek()[1];
            visit[x][y] = true;
            qu.poll();
            for (int i = 0; i < 4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];

                if (a >= 0 && b >= 0 && a < M && b < N) {
                    if (!visit[a][b] && map[a][b] == 1) {
                        qu.add(new int[] {a, b});
                        visit[a][b] = true;
                    }
                }
            }

        }
    }
}
