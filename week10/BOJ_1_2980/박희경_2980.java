package BOJ_1_2980;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박희경_2980 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 신호등 개수
        int L = Integer.parseInt(st.nextToken()); // 도로의 길이

        int position = 0;   // 도로 시작
        int time = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());   // 신호등 위치
            int R = Integer.parseInt(st.nextToken());   // 빨간불 지속 시간
            int G = Integer.parseInt(st.nextToken());   // 초록불 지속 시간

            time += D - position;   // 다음 신호등 위치까지 가는데 걸리는 시간
            position = D;   // 위치 갱신

            int section = time %  (R + G); // 빨간불인지 파란불인지 구간 파악
            if (section < R)        // 빨간불
                time += R - section;
        }
        time += L - position;   // 남은 신호등 거리 계산
        System.out.println(time);
    }
}
