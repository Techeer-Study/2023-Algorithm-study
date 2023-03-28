package BOJ_1_13458;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배준일_13458 {
    private static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 시험장의 개수

        StringTokenizer st = new StringTokenizer(br.readLine());  // 학생 수 한줄 담기

        int[] people = new int[n]; // 시험장에 있는 학생 수를 담은 배열

        for(int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine()); // 감독관들 감시 한줄 담기

        int b  = Integer.parseInt(st.nextToken()); // 총감독관 감시 수
        int c  = Integer.parseInt(st.nextToken()); // 부감독관 감시 수

        long answer = 0; // 100만 * 100만 > int의 범위(21억)

        for (int i = 0; i < n; i++) {
            answer ++; // 총감독관 ++
            people[i] -= b; // 총감독관의 감독

            if (people[i] <= 0) // 총감독관 선에서 끝나면 continue
                continue;

            answer += people[i] / c; // 부감독관 더하기

            if (people[i] % c != 0) { // 나머지 학생이 있으면 ++ (부감독관)
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
