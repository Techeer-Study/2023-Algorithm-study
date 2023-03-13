package Algo_1_10798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 정길연_10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strList = new String[5];
        int max = 0;

        for(int i=0; i<5; i++){
            strList[i] = br.readLine();
            if(max< strList[i].length())    max= strList[i].length();
        }

//        ArrayList result = new ArrayList<>();
//        ArrayList로 쓰면 toSting이 안되고, for문을 또 돌려야하는 단점이 있음
        StringBuilder result = new StringBuilder();
        for(int i=0; i<max; i++){
            for(int j=0; j<5; j++){
                if(strList[j].length() <= i) continue;
                result.append(strList[j].charAt(i));
            }
        }
        System.out.println(result.toString());


    }
}
