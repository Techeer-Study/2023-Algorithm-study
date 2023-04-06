package week04.BOJ_1_25325;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class 정길연_25325 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        ArrayList arr = new ArrayList<>();

        HashMap<String, Integer> hashMap = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            hashMap.put(st.nextToken(), 0); // 학생 이름 0으로 초기화
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); // 한 줄 체크를 위한 StringTokenizer 초기화

            while(st.hasMoreTokens()) {
                String s = st.nextToken();
                hashMap.put(s, hashMap.get(s) + 1); // 인기 + 1
            }
        }

        List<String> keySet = new ArrayList<>(hashMap.keySet());

        keySet.sort((o1, o2) -> { // 정렬
            if(hashMap.get(o1) - hashMap.get(o2) == 0)
                return o1.compareTo(o2);
            else
                return hashMap.get(o2) - hashMap.get(o1);
        });

        for(String key : keySet) {
            System.out.println(key + " " + hashMap.get(key));
        }


        br.close();
    }
}
