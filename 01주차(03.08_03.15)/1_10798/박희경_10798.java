import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 박희경_10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][] ch = new char[5][15]; // 행: 5, 열: 최대 15
        int max = 0; // 5개의 행 중 가장 긴 열 (가장 긴 문자열)

        for (int i = 0; i < ch.length; i++) {
            String str = br.readLine();
//            if (max < str.length()) max = str.length();
            max = Math.max(max, str.length()); // 가장 긴 입력받은 문자열
            for (int j = 0; j < str.length(); j++) {
                ch[i][j] = str.charAt(j); // 한 글자씩 넣기
            }
        }

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if (ch[j][i] == '\0') // 배열에 빈칸이 들어가도 반복문 계속
                    continue;
                sb.append(ch[j][i]);
            }
        }
        System.out.println(sb);
    }
}
