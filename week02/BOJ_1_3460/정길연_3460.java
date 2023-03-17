package BOJ_1_3460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정길연_3460  {
    static int T;

    static ArrayList arrList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
//        arr = new int[T];

        ArrayList resultList;
        for (int i = 0; i < T; i++) {
            resultList = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            toBinary(target);

            for (int j = 0; j < arrList.size(); j++) {
                if(arrList.get(j)==(Object) 1) resultList.add(j);
            }
            for(Object x: resultList) System.out.print(x + " ");
            System.out.println();
        }



    }

    private static void toBinary(int origin) {
        arrList = new ArrayList<>();
        while ( (origin != 1 && origin != 0) ) {  //!(origin==1 || origin==0)
            arrList.add(origin % 2);
            origin /= 2;
        }
        arrList.add(origin);
    }
}
