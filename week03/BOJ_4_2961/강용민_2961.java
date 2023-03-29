package week03.BOJ_4_2961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 강용민_2961{
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[][] arr;
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(sb.readLine());
        arr = new int[N][2];
        visited = new boolean[N];

        for(int n = 0; n<N;n++){
            st = new StringTokenizer(sb.readLine());
            arr[n][0] = Integer.parseInt(st.nextToken());
            arr[n][1] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int depth){
        if(depth == N){
            int cnt = 0;
            int S = 1, B = 0;
            for(int i = 0; i < N; i++){
                if(visited[i]){
                    cnt++;
                    S *= arr[i][0];
                    B += arr[i][1];
                }
            }
            if(cnt == 0) return;
            answer = Math.min(answer,Math.abs(S-B));
            return;
        }

        visited[depth] = true;
        dfs(depth+1);

        visited[depth] = false;
        dfs(depth+1);
    }
}