package BOJ_5_1461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 박희경1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 책의 개수
        int M = Integer.parseInt(st.nextToken()); // 한 번에 들 수 있는 책의 개수

        ArrayList<Integer> negative = new ArrayList<>(); // 음의 번호에 가야하는 책
        ArrayList<Integer> positive = new ArrayList<>(); // 양의 번호에 가야하는 책

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {   // 음, 양으로 나누기
            int book = Integer.parseInt(st.nextToken());
            if (book > 0)
                positive.add(book);
            else negative.add(book);
        }

        negative.sort(Collections.reverseOrder()); // 내림차순
        positive.sort(Collections.reverseOrder());


        ArrayList<Integer> distance = new ArrayList<>();
        // 음의 위치부터 책 정리
        while(!negative.isEmpty()) {
            int temp = 0; // 이동해야하는 거리
            temp = negative.remove(0);
            for (int i=1; i<M; i++) {
                if (!negative.isEmpty()) {
                    negative.remove(0);
                }
            }
            distance.add(-temp);
        }

        // 양의 위치 책 정리
        while(!positive.isEmpty()) {
            int temp = 0; // 이동해야하는 거리
            temp = positive.remove(0);
            for (int i=1; i<M; i++) {
                if (!positive.isEmpty()) {
                    positive.remove(0);
                }
            }
            distance.add(temp);
        }

        int result = 0;
        Collections.sort(distance); // 가장 먼 거리를 알기 위해 sort
        for (int i=0; i<distance.size(); i++) {
            //  왕복 거리 계산 x2
            if (i == distance.size()-1) result += distance.get(i);
            else result += (distance.get(i)*2);
        }

        System.out.println(result);
    }
}
