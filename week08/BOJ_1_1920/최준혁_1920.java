package week08.BOJ_1_1920;

import java.util.*;
import java.io.*;

public class 최준혁_1920 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] nArray = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int m = Integer.parseInt(br.readLine());
        int[] mArray = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 이진 탐색을 위한 정렬이 선행되어야 함
        Arrays.sort(nArray);

        for (int i = 0; i < m; i++) {
            if (Arrays.binarySearch(nArray, mArray[i]) < 0) {   // 이진 탐색(찾는 대상이 없으면 0보다 작은 수를 반환함)
                bw.write("0\n");
            } else {
                bw.write("1\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
