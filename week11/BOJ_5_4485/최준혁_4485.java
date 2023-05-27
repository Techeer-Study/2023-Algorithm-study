package week11.BOJ_5_4485;

import java.io.*;
import java.util.*;

public class 최준혁_4485 {
    static int[][] graph;
    static final int INF = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1번에서 N번 정점으로 가는 최단거리 구하기
        int N = Integer.parseInt(st.nextToken());   // 정점의 개수
        int E = Integer.parseInt(st.nextToken());   // 간선의 개수

        graph = new int[N][N];

        // a번 정점에서 b번 정점까지 양방향 길이 존재. 거리는 c
        for (int[] colArray : graph) {
            Arrays.fill(colArray, INF);
        }

        // graph initialize
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[x - 1][y - 1] = cost;
            graph[y - 1][x - 1] = cost;
        }

        // 다익스트라
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int point1 = Integer.parseInt(st.nextToken());
        int point2 = Integer.parseInt(st.nextToken());

        int minPathCost = graph[0][point1 - 1] + graph[point1 - 1][point2 - 1] + graph[point2 - 1][N - 1];

        System.out.println(minPathCost);
    }
}
