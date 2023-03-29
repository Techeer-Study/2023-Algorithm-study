package BOJ_5_1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정길연_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] reservation = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            reservation[i][0] = Integer.parseInt(st.nextToken());
            reservation[i][1] = Integer.parseInt(st.nextToken());
        }

        // 두번째 인덱스 기준 정렬 - 종료시간이 빠른 순서
        Arrays.sort(reservation, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0]-o2[0];
            else return o1[1]-o2[1];
        });

        int cnt = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {   // i는 필수로 들어갈때
            if (reservation[i][0] >= end) {
                cnt++;
                end = reservation[i][1];
            }
        }

        System.out.println(cnt);
    }

}
