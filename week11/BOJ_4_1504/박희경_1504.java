package BOJ_4_1504;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 박희경_1504 {
    static class Node implements Comparable<Node>{
        int dest, cost;

        Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
    static ArrayList<Node>[] list;
    static int N, E;
    static int[] distance;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        distance = new int[N + 1];

        for(int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long sum1 = 0;  // 1 > v1 > v2 > N
        sum1 += dijkstra(1, v1);
        sum1 += dijkstra(v1, v2);
        sum1 += dijkstra(v2, N);

        long sum2 = 0; // 1 > v2 > v1 > N
        sum2 += dijkstra(1, v2);
        sum2 += dijkstra(v2, v1);
        sum2 += dijkstra(v1, N);
        if (Math.min(sum1, sum2) >= INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(Math.min(sum1, sum2));
    }

    private static int dijkstra(int start, int end) {
        distance = new int[N + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int dest = node.dest;
            int cost = node.cost;
            if (distance[dest] < cost) {
                continue;
            }
            for (int i = 0; i < list[dest].size(); i++) {
                int dest2 = list[dest].get(i).dest;
                int cost2 = list[dest].get(i).cost + cost;
                if (distance[dest2] > cost2) {
                    distance[dest2] = cost2;
                    queue.add(new Node(dest2, cost2));
                }
            }
        }
        return distance[end];
    }
}
