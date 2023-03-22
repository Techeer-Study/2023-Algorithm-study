package BOJ_4_10974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 박희경_10974 {
    static int N;
    static int[] arr; // 순열을 담을 배열
    static boolean[] visit; // 방문 체크
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        visit = new boolean[N+1];

        dfs(0);
    }

    // DFS
    public static void dfs(int idx){
        if(idx == N){
            for(int x : arr){
                System.out.print(x+" ");
            }
            System.out.println();
            return;
        }
        for(int i=1; i<=N; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[idx] = i;
                dfs(idx+1);
                visit[i] = false;
            }
        }
    }
}
