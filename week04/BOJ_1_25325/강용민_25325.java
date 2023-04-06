package week04.BOJ_1_25325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 강용민_25325{
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] values = new int[N][2];

        //dict 생성
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer,String> dict_key = new HashMap<>();
        Map<String,Integer> dict_value = new HashMap<>();
        for(int n = 0; n < N; n++){
            String student = st.nextToken();
            dict_value.put(student,n);
            dict_key.put(n,student);
            values[n][0] = n;
        }

        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                String student = st.nextToken();
                values[dict_value.get(student)][1] += 1;
            }
        }

        Arrays.sort(values,(o1,o2) ->{
            if(o1[1] == o2[1]){
                return dict_key.get(o1[0]).compareTo(dict_key.get(o2[0]));
            }
            else return o2[1]-o1[1];
        });

        for(int[] value : values){
            sb.append(dict_key.get(value[0])).append(" ").append(value[1]).append("\n");
        }
        System.out.println(sb);
    }
}