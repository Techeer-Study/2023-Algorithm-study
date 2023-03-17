import java.io.*;
import java.util.*;

public class 배준일_2960 {
    private static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 문자열 분리 (split 역할)

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int[] nList = new int[n + 1];

        for(int i = 2; i < n + 1; i++) { // 배열 안에 값 넣기
            nList[i] = i;
        }

        for(int i = 2; i < n + 1; i++) {
            for(int j = i; j < n + 1; j += i) {
                if(nList[j] != 0) {
                    nList[j] = 0; // j의 배수 0으로 초기화
                    cnt ++; // 횟수 측정
                }

                if(cnt == k) { // k만큼 지우면 출력
                    System.out.println(j);
                    return;
                }
            }
        }

        br.close();
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
