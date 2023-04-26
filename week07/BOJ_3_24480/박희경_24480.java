package BOJ_3_24480;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 박희경_24480 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visit;
    static int[] seq;
    static int M, N, R, sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];
        seq = new int[N];
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (ArrayList<Integer> d : graph) {
            d.sort(Collections.reverseOrder());
        }
        dfs(R);
        for (int i : seq) {
            System.out.println(i);
        }
    }
    public static void dfs(int start) {
        if (!visit[start]) {
            seq[sequence++] = start;
            visit[start] = true;
            for (Integer integer : graph.get(start)) {
                dfs(integer);
            }
        }
    }
}
