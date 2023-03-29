package week03.BOJ_5_1931;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class 최준혁_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> schedule = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> room = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
            schedule.add(room);
        }

        // 끝나는 시간 순으로 정렬
        schedule.sort((i1, i2) -> {
            // 시작과 끝이 동일한 회의 시간도 존재하기 때문에 끝나는 시간이 같은 경우 시작 시간이 빠른 회의가 앞에 오도록 정렬해야 함
            if (i1.get(1) - i2.get(1) == 0)
                return i1.get(0) - i2.get(0);
            return i1.get(1) - i2.get(1);
        });

        int chosen_end_time = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (chosen_end_time > schedule.get(i).get(0))
                continue;

            chosen_end_time = schedule.get(i).get(1);
            count += 1;
        }

        System.out.println(count);
    }
}
