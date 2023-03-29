package BOJ_1_13458;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정길연_13458 {

    static int N, B, C;
    static int[] students;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        students = new int[N];
        for (int i = 0; i < N; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());   // 총감독관이 담당하는 사람
        C = Integer.parseInt(st.nextToken());   // 부감독관이 담당하는 사람

        long total = 0;
        for (int stu : students) {
            if (stu > B) {
                total += Math.ceil((stu - B) / (C * 1.0)) + 1;
            } else {
                total += 1;
            }
        }

        System.out.println(total);


        br.close();
    }
}
