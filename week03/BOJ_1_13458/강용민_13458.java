package week03.BOJ_1_13458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 강용민_13458{

    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] takers = new int[N];
        long answer = N;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N;i++){
            takers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            takers[i] -= B;
            if(takers[i] > 0){
                answer += Math.ceil((double)takers[i]/C);
            }
        }

        System.out.println(answer);
    }
}