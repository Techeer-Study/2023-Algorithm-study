package BOJ_2_13305;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정길연_13305 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dist = new long[N - 1];	// dist : 거리
        long[] cost = new long[N];	// cost : 비용

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N - 1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }

        // 리터당 기름값 입력
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        long minCost = cost[0];	// 이전 까지의 과정 중 주유 최소 비용

        for(int i = 0; i < N - 1; i++) {
             // 현재 주유소가 이전 주유소의 기름값보다 쌀 경우 minCost 갱신
            if(cost[i] < minCost) minCost = cost[i];

            sum += (minCost * dist[i]);
        }
        System.out.println(sum);
    }

}
