package Algo_4_2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 정길연_2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        // 1. 2~n 배열 초기화
        int[] arr = new int[n+1];
        for (int i = 2; i <= n; i++)   arr[i] = i;

        // 2. 배수 지우기
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) continue;
            // i의 배수 j 지우기
            for (int j = i; j <= n; j+=i) {
                if (arr[j] != 0) {
                    arr[j] = 0;
                    cnt ++;
                    if(k==cnt) {
                        System.out.println(j); // k번째에 지운 수
                        break;
                    }
                }
            }
            if(k==cnt) {
                break;
            }
        }

    }
}
