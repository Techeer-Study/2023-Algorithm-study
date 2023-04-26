package BOJ_2_24479;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 박희경_24479 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();;
    static int N, M, start;
    static int[] seq;
    static boolean[] visit;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

//        graph = new ArrayList<>();
        seq = new int[N+1];
        visit = new boolean[N+1];

        for (int i = 0; i <=N; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <=N; i++)
            Collections.sort(graph.get(i));

        seq[start] = 1;
        visit[start] = true;
        count = 2;
        dfs(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++)
            sb.append(seq[i]).append("\n");

        System.out.println(sb);

    }
    public static void dfs(int root) {
        for (int v : graph.get(root)) {
            if (!visit[v]) {
                seq[v] = count++;
                visit[v] = true;
                dfs(v);
            }
        }
    }
}
