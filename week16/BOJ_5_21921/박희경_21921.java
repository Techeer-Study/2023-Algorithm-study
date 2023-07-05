package BOJ_5_21921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박희경_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int end = 0;
        int sum = 0;
        int max = 0;
        int count = 1;

        for(int i=0; i < N; i++){
            while((end - i < X) && end < N){
                sum += arr[end];
                end++;
            }

            if(max == sum){
                count++;
            }
            else if(max < sum){
                max = sum;
                count = 1;
            }

            sum -= arr[i];
        }

        if(max == 0){
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(count);
    }
}
