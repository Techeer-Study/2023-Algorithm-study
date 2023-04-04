package week04.BOJ_3_1021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class 배준일_1021 {
    private static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            list.add(i);

        st = new StringTokenizer(br.readLine());
        int cnt = 0;    //횟수

        while (m-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            int idx = list.indexOf(num);

            // 1번 연산
            if (idx == 0) {
                list.pollFirst();
                continue;
            }

            // 2번 연산
            if (idx < list.size() - idx) {
                for (int i = 0; i < idx; i++ ){
                    list.offerLast(list.pollFirst()); // 앞에서 제거 후 뒤에 삽입
                }
                cnt += idx;
            }
            else { // 3번 연산
                for (int i = 0; i < list.size() - idx; i++){
                    list.offerFirst(list.pollLast()); // 앞에서 제거 후 뒤에 삽입
                }
                cnt += list.size() - idx;
            }
            list.pollFirst(); // 인덱스 0 제거
        }

        System.out.println(cnt);

    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
