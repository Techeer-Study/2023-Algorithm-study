package BOJ_5_1647;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 박희경_1647 {
    static int[] parent;

    public static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;
        parent[a] = b;
        return true;
    }

    public static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;

        PriorityQueue<node> q = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            q.add(new node(a, b, c));
        }

        int cnt = 0;
        int sum = 0;
        while(!q.isEmpty()) {
            node node = q.poll();
            int s = node.s;
            int e = node.e;
            int v = node.v;

            if(union(s, e)) {
                cnt++;
                sum += v;
            }
            if(cnt == N-2) break;
        }
        System.out.println(sum);
    }
}
class node implements Comparable<node>{
    int s, e, v;

    public node(int s, int e, int v) {
        super();
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(node o) {
        return this.v - o.v;
    }
}