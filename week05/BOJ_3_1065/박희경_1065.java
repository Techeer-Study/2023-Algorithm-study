package BOJ_3_1065;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 박희경_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 1; i <= num; i++) { //입력 범위가 1이상이므로 1부터 시작.
            if (i <= 99) { //1~99까지는 모두 한수이므로 무조건 +1
                count += 1;
            } else if (i <= 999) {
                String[] num_str = Integer.toString(i).split(""); //각 자리수를 자정할 문자열 배열 생성.
                if ((Integer.parseInt(num_str[1]) - Integer.parseInt(num_str[0])) == (Integer.parseInt(num_str[2])- Integer.parseInt(num_str[1]))) { // 공차가 같다면 한수이므로
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}
