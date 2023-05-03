package BOJ_2_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 박희경_10816 {
    public static int[] arr;
    public static int low, high, mid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine()," ");

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(upperBound(target) - lowerBound(target)).append(' ');
        }
        System.out.println(sb);
    }

    private static int lowerBound(int target) {
        low = 0;
        high = arr.length;

        while(low < high) {
            mid = (low + high) / 2;

            if(target <= arr[mid]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int upperBound(int target) {
        low = 0;
        high = arr.length;

        while(low < high) {
            mid = (low + high) / 2;

            if(target < arr[mid]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}
