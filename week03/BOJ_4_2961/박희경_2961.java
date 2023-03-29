package BOJ_4_2961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박희경_2961 {
    static int n;
    static int[][] tastes;
    static int minTaste = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         n = Integer.parseInt(br.readLine());
        tastes = new int[n][2];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tastes[i][0] = Integer.parseInt(st.nextToken());
            tastes[i][1] = Integer.parseInt(st.nextToken());
        }
        subSet(0,1,0, 0);

        System.out.println(minTaste);
    }

    public static void subSet(int cnt, int sour, int bitter, int c) {
        if(cnt == n) {
            if(minTaste > Math.abs(sour-bitter) && c !=0) {
                minTaste = Math.abs(sour-bitter);
            }
            return;
        }
        subSet(cnt + 1, sour * tastes[cnt][0], bitter + tastes[cnt][1], c + 1);
        subSet(cnt + 1, sour, bitter, c);
    }
}
