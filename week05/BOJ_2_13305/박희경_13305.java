package BOJ_2_13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박희경_13305 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] distance = new long[N - 1];
        long[] cost = new long[N];

        // 거리 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N - 1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        // 리터당 기름값 입력
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        long minCost = cost[0];

        for(int i = 0; i < N - 1; i++) {
            if(cost[i] < minCost) {     // 현재 주유소가 이전 주유소보다 저렴한 경우 갱신
                minCost = cost[i];
            }
            sum += (minCost * distance[i]);
        }

        System.out.println(sum);

    }
}
