package BOJ_3_2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 박희경_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int low = 0;
        int high = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, arr[i]);
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        while(low <= high) {
            int mid = (low + high) / 2;
            long budget = 0;

            for(int i = 0; i < N; i++) {
                budget += Math.min(arr[i], mid);
            }

            if(budget <= M) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(high);
    }
}
