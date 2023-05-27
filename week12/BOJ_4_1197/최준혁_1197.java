package week12.BOJ_4_1197;

import java.io.*;
import java.util.*;

class Edge {
    private int distance;
    private int nodeA;
    private int nodeB;

    public Edge(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getNodeA() {
        return this.nodeA;
    }

    public int getNodeB() {
        return this.nodeB;
    }
}

public class 최준혁_1197 {
    public static int v, e; // 노드의 개수(V)와 간선(Union 연산)의 개수(E)
    public static int[] parent = new int[100001]; // 부모 테이블 초기화하기(노드의 개수는 최대 100,000개라고 가정)
    public static ArrayList<Edge> edges = new ArrayList<>();    // 모든 간선을 담을 리스트와, 최종 비용을 담을 변수
    public static int result = 0;

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        parent[x] = findParent(parent[x]);  // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        return parent[x];
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // 모든 간선에 대한 정보를 입력 받기
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(cost, a, b));
        }

        // 간선을 비용순으로 정렬
        Collections.sort(edges,
                (e1, e2) -> e1.getDistance() - e2.getDistance());

        // 간선을 하나씩 확인하며
        for (int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).getDistance();
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();

            if (findParent(a) != findParent(b)) {   // 사이클이 발생하지 않는 경우에만 집합에 포함
                unionParent(a, b);
                result += cost;
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();

        br.close();
    }
}
