package week10.BOJ_1_1713;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class 최준혁_1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());     // 학생 수
        int C = Integer.parseInt(br.readLine());    // 총 추천 수

        // 추천 받은 학생 순서 배열
        int[] recommendArray = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 추천 기록용 (학생 번호, 추천 수)
        Map<Integer, Integer> recordMap = new HashMap<>();

        // 사진 틀
        List<Integer> mold = new ArrayList<>();

        for (int studentNum : recommendArray) {
            if (mold.size() < 3) {  // 자리가 아직 안 차 있는 경우
                recordMap.put(studentNum, recordMap.getOrDefault(studentNum, 0) + 1);
                if (!mold.contains(studentNum)) {
                    mold.add(studentNum);
                }
                continue;
            }

            if (mold.contains(studentNum)) {    // 자리가 차 있지만, 중복 인자가 들어온 경우
                recordMap.put(studentNum, recordMap.getOrDefault(studentNum, 0) + 1);
                continue;
            }

            // 자리가 차 있고, 사진 틀에서 빼야하는 경우

            // 최소 추천 학생 삭제
            int minValue = Collections.min(recordMap.values());

            List<Integer> minKeyList = recordMap.keySet().stream()
                    .filter(key -> recordMap.get(key) == minValue)
                    .collect(Collectors.toList());

            Integer minOldKey = minKeyList.stream()
                    .min((k1, k2) -> mold.indexOf(k1) - mold.indexOf(k2))
                    .get();

            mold.remove(minOldKey);
            recordMap.remove(minOldKey);

            // 새로운 학생 추가
            mold.add(studentNum);
            recordMap.put(studentNum, 1);
        }

        Collections.sort(mold);

        String answer = mold.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        bw.write(answer);
        bw.flush();
        bw.close();
    }
}
