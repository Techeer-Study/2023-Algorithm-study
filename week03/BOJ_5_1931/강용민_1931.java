package week03.BOJ_5_1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 강용민_1931{

    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int answer = 0, pre = 0;

        for(int n = 0; n < N ; n++){
            st = new StringTokenizer(br.readLine());
            arr[n][0] = Integer.parseInt(st.nextToken());
            arr[n][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr,new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) 
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });


        for(int i = 0; i < N; i++){
            if(pre <= arr[i][0]){
                pre = arr[i][1];
                answer++;
            }
        }

        System.out.println(answer);
    }
}