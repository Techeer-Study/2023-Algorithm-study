import java.io.*;
import java.util.*;

public class Main {
    private static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 문자열 분리 (split 역할)
        int a = Integer.parseInt(st.nextToken()); // 처음 문자
        int b = Integer.parseInt(st.nextToken()); // 두번째 문자

        System.out.println(gcd(a, b)); // 최대 공약수
        System.out.println(lcd(a, b)); // 최소 공배수

        br.close();
    }

    private static int lcd(int a, int b) { // 최소 공배수
        return a * b / gcd(a, b);
    }

    private static int gcd(int a, int b) { // 최대 공약수
        while (b != 0) {
            int r = a % b;
            a = b; // 나누는 값
            b = r; // 나눈 나머지
        }
        return a;
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
