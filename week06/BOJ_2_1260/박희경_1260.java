package BOJ_2_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 박희경_1260 {
    static boolean[] visit;
    static int[][] arr;
    static int node, line, start;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start= Integer.parseInt(st.nextToken());

        arr = new int[node + 1][node + 1];
        visit = new boolean[node + 1];

        for(int i = 0 ; i < line ; i ++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] =  1;
        }

        dfs(start);
        System.out.println();
        visit = new boolean[node + 1];

        bfs(start);
    }
    public static void dfs(int start) {

        visit[start] = true;
        System.out.print(start + " ");

        for(int i = 0 ; i <= node ; i++) {
            if(arr[start][i] == 1 && !visit[i])
                dfs(i);
        }
    }
    public static void bfs(int start) {
        q.add(start);
        visit[start] = true;

        while(!q.isEmpty()) {
            start = q.poll();
            System.out.print(start + " ");

            for(int i = 1 ; i <= node ; i++) {
                if(arr[start][i] == 1 && !visit[i]) {
                    q.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}
