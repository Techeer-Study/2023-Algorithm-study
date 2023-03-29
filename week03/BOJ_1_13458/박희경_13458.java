package BOJ_1_13458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박희경_13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 시험장 개수

        int[] arr = new int[n]; // 응시자수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());   // 총감독관이 감시할 수 있는 응시생
        int c = Integer.parseInt(st.nextToken());   // 부감독관이 감시할 수 있는 응시생

        long answer = 0; // 감독관의 수, 최대가 1,000,000명이기 때문에 long

        answer += n; // 총감독관의 수만큼 증가

        // 부감독관 구하기
        for (int i = 0; i < n; i++) {
            arr[i] -= b;    // 총감독관이 감시할 수 있는 응시생 빼기
            if (arr[i] <= 0)
                continue;
            answer += arr[i] / c;   // 남은 응시생에서 부감독관이 감시할 수 있는 응시생 나누기
            if (arr[i] % c != 0) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
