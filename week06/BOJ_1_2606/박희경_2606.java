package BOJ_1_2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 박희경_2606 {
    static boolean[] visit;
    static int[][] arr;
    static int count = 0;
    static int node, line;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        node = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        line = Integer.parseInt(br.readLine()); // 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수

        arr = new int[node +1][node + 1];
        visit = new boolean[node + 1];

        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        q.add(1);   // 시작 노드
        visit[1] = true;    // 현재 노드 방문처리

        while (!q.isEmpty()) {
            int v = q.poll();   // 큐에서 하나의 원소를 뽑아 출력
            for (int i = 1; i <= node; i++) {
                if (arr[v][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    q.add(i);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
