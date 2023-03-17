package BOJ_1_3460;

import java.io.*;

public class 배준일_3460 {
    private static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            String nToBinary = Integer.toBinaryString(n); // 이진수로 변환

            for(int j = nToBinary.length() - 1; j >= 0; j--) { // 위치가 낮은것 부터 출력하기 위해 j--
                if(nToBinary.charAt(j) == '1') { // j 위치에서 1일 때
                    sb.append(nToBinary.length() - j - 1).append(" ");
                }
            }
            System.out.println(sb);
            sb.setLength(0); // StringBuilder 초기화
        }

    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
