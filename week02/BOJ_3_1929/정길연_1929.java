package BOJ_3_1929;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정길연_1929 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());   // M부터
        int N = Integer.parseInt(st.nextToken());   // N까지
        int arr[] = new int[N+1];     // N까지 숫자 넣을 배열

        /*
         * 1. arr[] 초기화
         * 2. N까지 에라토스테네스의 체 - 배수는 0으로 초기화
         * 3. StringBuilder 에 값 넣어주기
         */

        for (int i = 2; i <= N; i++) {
            arr[i] = i;
        }

        int maxRange = (int) Math.sqrt(N);
        for (int i = 2; i <= maxRange; i++) {
            if(arr[i] == 0) continue;
            for(int j = i+i; j<= N; j+= i) arr[j] = 0;  // j = i+i 여야지 2,3,5등의 소수가 지워지지않는다.
        }

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (arr[i] != 0) sb.append(i+ "\n");
        }

        System.out.println(sb.toString());

    }
}
