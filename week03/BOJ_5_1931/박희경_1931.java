package BOJ_5_1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 박희경_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] time = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken()); // 회의시작시간
            time[i][1] = Integer.parseInt(st.nextToken()); // 회의종료시간
        }

        // 회의가 끝나는 시간 기준으로 오름차순
        Arrays.sort(time, (o1, o2) -> {
            if (o1[1] == o2[1]) { //회의 종료시간이 같다면 시작 시간이 빠른 순으로
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1]; //회의 종료시간 정렬
        });

        int count = 0;  // 하루 최대 회의 수
        int endTime = 0;

        for (int i = 0; i < n; i++) {
            if (endTime <= time[i][0]) {
                endTime = time[i][1];
                count++;
            }
        }

        System.out.println(count);

    }
}
