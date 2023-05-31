package BOJ_4_1197;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 박희경_1197 {
    static int E, V, sum = 0;
    static int[] parent;
    static List<node> list = new ArrayList<>();

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        E = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        parent = new int[E + 1];

        for (int i = 1; i <= E; i++)
            parent[i] = i;

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new node(s, e, v));
        }

        // 간선의 크기 오름차순 정렬
        Collections.sort(list);

        // 크루스칼 알고리즘
        for(node node : list){
            int s = node.s;
            int e = node.e;
            int v = node.v;

            if(find(s) == find(e))
                continue;
            sum += v;
            union(s, e);
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

    // 간선의 크기로 오름차순하기 위한 compareTo()메서드
    @Override
    public int compareTo(node o) {
        return this.v - o.v;
    }
}
