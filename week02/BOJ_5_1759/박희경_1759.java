package BOJ_5_1759;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 박희경_1759 {
    public static int L, C; // 서로 다른 L개의 알파벳 소문자 = 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음
                            // C: 암호화 가능한 경우의 수
    public static char[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        visit = new boolean[C];

        st = new StringTokenizer(br.readLine());

        for (int x = 0; x < C; x++) {
            arr[x] = st.nextToken().charAt(0);
        }

        // 정렬
        Arrays.sort(arr);

        code(0,0);
    }

    // 암호 만들기
    public static void code(int x,int idx) {
        if (idx == L) {
            // 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음인지 확인
            int v = 0; // 모음
            int c = 0; // 자음
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < C; i++) {
                if (visit[i]) {
                    sb.append(arr[i]);

                    if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                        v++;
                    } else {
                        c++;
                    }
                }
            }
            if (v >= 1 && c >= 2) System.out.println(sb);
        }

        // 백트래킹
        for (int i = x; i < C; i++) {
            visit[i] = true;
            code(i + 1, idx + 1);
            visit[i] = false;
        }
    }
}
