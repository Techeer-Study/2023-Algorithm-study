package BOJ_4_16401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 박희경_16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int low = 1;
        int high = arr[N-1];

        while(low <= high) {
            int mid = (low + high) / 2;
            int sum = 0;

            for(int i=0; i < N; i++) {
                if(arr[i] >= mid)
                    sum += arr[i] / mid;
            }

            if(sum >= M) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        System.out.println(high);
    }
}
