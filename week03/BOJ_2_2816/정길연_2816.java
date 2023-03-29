package BOJ_2_2816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정길연_2816 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] channel = new String[N];

        for (int i = 0; i < N; i++) {
            channel[i] = br.readLine();
        }

        // KBS1 먼저 찾기
        for (int i = 0; i < N; i++) {
            if (channel[i].equals("KBS1")) {
                for (int j = i; j > 0; j--) {
                    System.out.print(4);    // 올라가기
                    swap(channel[j], channel[j - 1]);
                } break;
            } else
                System.out.print(1);  // KBS1 찾을 때까지 내려가기
        }

        // KBS2 찾기
        if(channel[1].equals("KBS2")) System.exit(0);
        for (int i = 0; i < N; i++) {
            if (channel[i].equals("KBS2")) {
                for (int j = i; j > 1; j--) {
                    System.out.print(4);
                    swap(channel[j], channel[j - 1]);
                } break;
            } else System.out.print(1);
        }


        br.close();
    }
    private static void swap(String a, String b) {
        String tmp = "";
        tmp = a;
        a = b;
        b = tmp;
    }

}

