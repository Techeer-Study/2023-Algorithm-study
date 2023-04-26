package week07.BOJ_3_24480;

import java.io.*;
import java.util.*;

public class 최준혁_24480 {
    public static int depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 정점의 수
        int m = Integer.parseInt(st.nextToken());   // 간선의 수
        int r = Integer.parseInt(st.nextToken());   // 탐색 시작 노드

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        graph.forEach(l -> l.sort((i1, i2) -> i2 - i1));

        int[] visited = new int[n + 1];
        depth = 1;
        dfs(graph, r, visited);

        for (int i = 1; i < visited.length; i++) {
            System.out.println(visited[i]);
        }
    }

    public static void dfs(List<List<Integer>> graph, int node, int[] visited) {
        visited[node] = depth;

        for (int adjNode : graph.get(node)) {
            if (visited[adjNode] == 0) {
                depth += 1;
                dfs(graph, adjNode, visited);
            }
        }
    }
}