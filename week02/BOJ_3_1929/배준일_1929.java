package BOJ_3_1929;
import java.util.*;
import java.io.*;
public class 배준일_1929 {
    private static void solution() throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine()); // 문자열 분리 (split 역할)

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int[] numList = new int[n + 1];

            for(int i = 2; i < n + 1; i++) {
                numList[i] = i;
            }

            for(int i = 2; i < n + 1; i++) {
                if(numList[i] == 0) // 초기화한 값 continue
                    continue;

                for(int j = i + i; j < n + 1; j += i) { // 시작을 i+i부터 해서 소수 제외
                    numList[j] = 0; // 0으로 초기화
                }
            }

            for(int i = m; i < n + 1; i++) { // 시작값 m
                if(numList[i] != 0) { // 소수인 값 append
                    sb.append(i).append("\n");
                }
            }
            System.out.println(sb);
        }
        public static void main(String[] args) throws Exception {
            solution();
        }
}
