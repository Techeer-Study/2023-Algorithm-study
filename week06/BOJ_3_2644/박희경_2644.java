package BOJ_3_2644;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 박희경_2644 {
    static int n, m, start, end;
    static int[][] arr;
    static int[] dist;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st =  new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] =  1;
        }
        dist = new int[n + 1];

        bfs(start, end);
        if (dist[end] == 0)
            System.out.println(-1);
        else
            System.out.println(dist[end]);
    }
    public static void bfs(int start, int end) {
        q.add(start);

        while(!q.isEmpty()) {
            int v = q.poll();
            if (v == end)
                break;
            for (int i = 1; i <= n; i++) {
                if (arr[v][i] == 1 && dist[i] == 0) {
                    dist[i] = dist[v] + 1;
                    q.add(i);
                }
            }
        }
    }
}
