package BOJ_4_2304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 박희경_2304 {
    static class LowHigh{
        int low;
        int high;

        public LowHigh(int low, int high) {
            this.low = low;
            this.high = high;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<LowHigh> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            list.add(new LowHigh(L, H));
        }

        list.sort(Comparator.comparingInt(o -> o.low)); //x축 기준 정렬

        int area = 0;
        int maxHeightPoint = 0;

        LowHigh highCol = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            LowHigh currentCol = list.get(i);

            if (highCol.high <= currentCol.high) {
                area += (currentCol.low - highCol.low) * highCol.high;
                highCol = currentCol;
                maxHeightPoint = i;
            }
        }

        highCol = list.get(list.size() - 1);
        for (int i = 1; i < list.size() - maxHeightPoint; i++) {
            LowHigh currentCol = list.get(list.size() - 1 - i);

            if (highCol.high <= currentCol.high) {
                area += (highCol.low - currentCol.low) * highCol.high;
                highCol = currentCol;
            }
        }

        area += list.get(maxHeightPoint).high;

        System.out.println(area);
    }
}
