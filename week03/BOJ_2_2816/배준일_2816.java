package BOJ_2_2816;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배준일_2816 {
    private static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] channel = new String[n];
        for (int i = 0; i < n; i++) {
            channel[i] = br.readLine();
        }
        // KBS1 설정
        setting(channel, "KBS1", 0);

        // KBS2 설정
        setting(channel, "KBS2", 1);
    }

    public static void swap(String[] channel, int idx) {
        String temp = channel[idx];
        channel[idx] = channel[idx - 1];
        channel[idx - 1] = temp;
    }

    public static void setting(String[] channel, String targetName, int targetIdx) {
        int kbsIdx = 0;

        // target의 index를 찾는 과정(찾을 때까지 1번 버튼을 누른다)
        for (int i = 0; i < channel.length; i++) {
            if (channel[i].equals(targetName)) {
                kbsIdx = i;
                break;
            }
            System.out.print(1);
        }

        // target을 target의 위치에 오도록 설정(4번 버튼을 누른다)
        while (kbsIdx > targetIdx) {
            swap(channel, kbsIdx--);
            System.out.print(4);
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
