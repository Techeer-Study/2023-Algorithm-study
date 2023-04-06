package BOJ_3_1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 박희경_1021 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            list.add(i);

        st = new StringTokenizer(br.readLine());
        int cnt = 0;

        for (int i = 0; i < m; i ++) {
            int num = Integer.parseInt(st.nextToken());
            int idx = list.indexOf(num);

            // 1번 연산
            if (idx == 0) {
                list.remove(0);
                continue;
            }

            // 2번 연산
            if (idx < list.size() - idx) {
                for (int j = 0; j < idx; j++ ){
                    list.add(list.remove(0));
                }
                cnt += idx;
            }
            else { // 3번 연산
                for (int j = 0; j < list.size() - idx; j++){
                    int tmp = list.remove(list.size() -1);
                    list.add(0, tmp);
                }
                cnt += list.size() - idx;
            }
            list.remove(0);
        }

        System.out.println(cnt);
    }
}
